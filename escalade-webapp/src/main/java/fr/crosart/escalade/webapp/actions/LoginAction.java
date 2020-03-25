package fr.crosart.escalade.webapp.actions;


import com.opensymphony.xwork2.ActionSupport;
import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import javax.inject.Inject;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

/**
 * Action de gestion de la connexion/déconnexion d'un utilisateur
 */
public class LoginAction extends ActionSupport implements SessionAware {


    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    @Inject
    private User userBean;

    // ----- Paramètres en entrée
    private String login;
    private String password;


    // ----- Eléments Struts
    private Map<String, Object> session;
    private String nickname;
    private String firstname;
    private String lastname;
    private String mail;
    private String telephone;


    // ==================== Getters/Setters ====================
    public String getLogin() {
        return login;
    }
    public void setLogin(String pLogin) {
        login = pLogin;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pPassword) {
        password = pPassword;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


    // ==================== Méthodes ====================
    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     */

    public String doLogin() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(mail, password)) {
                try {

                    User vUser = managerFactory.getUserManager().logUser(mail.toLowerCase());

                    if (password.equals(vUser.getPassword())) {

                        // Ajout de l'utilisateur en session
                        this.session.put("user", vUser);

                        vResult = ActionSupport.SUCCESS;

                    } else {

                        this.addActionError("Mail ou mot de passe invalide !");

                    }
                } catch (Exception vEx) {
                    this.addActionError("Mail inconnu");
                }
        }
        return vResult;
    }


    /**
     * Action de déconnexion d'un utilisateur
     * @return success
     */
    public String doLogout() {
        // Suppression de l'utilisateur en session
        this.session.remove("user");

        return ActionSupport.SUCCESS;
    }

    public String doSignin() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isEmpty(mail)) {
            try {
                userBean.setPassword(password);
                userBean.setNickname(nickname);
                userBean.setFirstName(firstname);
                userBean.setLastName(lastname);
                userBean.setMail(mail.toLowerCase());
                userBean.setTelephone(telephone);
                userBean.setMember(false);

                managerFactory.getUserManager().createUser(userBean);

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
