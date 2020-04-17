package fr.crosart.escalade.webapp.actions;

import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.Topo;
import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named("gestionUserAction")
public class GestionUserAction extends ActionSupport {

    @Inject
    private ManagerFactory managerFactory;

    @Getter private User user;
    @Getter private List<Topo> listTopo;

    @Setter private Integer id;
    @Setter private String mail;
    @Setter private String confirmPassword;
    @Setter private String password;
    @Setter private String nickname;
    @Setter private String firstname;
    @Setter private String lastname;
    @Setter private String telephone;

    /**
     * Action > Récupère les informations de l'utilisateur {@link User} déterminé
     * @return ERROR | SUCCESS
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.user.missing.id"));
        } else {
            try {
                user = managerFactory.getUserManager().getUserDetail(id);
                listTopo = managerFactory.getTopoManager().getListTopos(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.user.notfound", Collections.singletonList(id)));
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action > Crée un nouvel {@link User}
     * @return INPUT | SUCCESS
     */
    public String doSignUp() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isEmpty(mail)) {
            try {
                if (!confirmPassword.equals(password)) {
                    this.addActionError("Le mot de passe et la confirmation ne sont pas identiques");

                    return vResult;
                }
                user.setPassword(password);
                user.setNickname(nickname);
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setMail(mail.toLowerCase());
                user.setTelephone(telephone);
                user.setMember(false);
                managerFactory.getUserManager().createUser(user);

                vResult = ActionSupport.SUCCESS;
            } catch (DuplicateKeyException vEx) {
                String exception = vEx.getMessage();
                if (exception.contains("(usernickname)")) {
                    this.addActionError("Ce pseudo est déjà utilisé");
                } else if (exception.contains("(usermail)")) {
                    this.addActionError("Ce mail est déjà utilisé");
                }
            } catch (DataIntegrityViolationException vEx){
                String exception = vEx.getMessage();
                if (exception.contains("registereduser_usermail_check")) {
                    this.addActionError("Veuillez saisir une adresse mail valide");
                }
                if (exception.contains("registereduser_usernickname_check")) {
                    this.addActionError("Votre nom d'utilisateur ne peut comporter que des caractères alphanumériques");
                }
                if (exception.contains("registereduser_userpassword_check")) {
                    this.addActionError("Votre mot de passe ne peut contenir que des caractères alphanumériques et les caractères spéciaux : !\"#$%&()*+,-./:;<=>?@[\\]^_`{|}~");
                }
            } catch (Exception vEx) {
                vEx.printStackTrace();
                this.addActionError("Erreur lors de l'ajout !");
            }
        }
        return vResult;
    }
}