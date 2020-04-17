package fr.crosart.escalade.webapp.actions;

import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import lombok.Setter;

@Named("gestionLogAction")
public class GestionLogAction extends ActionSupport implements SessionAware {

    @Inject
    private ManagerFactory managerFactory;

    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Setter private String password;
    @Setter private String mail;

    /**
     * Action > Ajoute un {@link User} en session
     * @return INPUT | SUCCESS
     */
    public String doLogIn() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(mail, password)) {
            try {
                User vUser = managerFactory.getUserManager().logUser(mail.toLowerCase());
                if (password.equals(vUser.getPassword())) {
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
     * Action > Supprime l'{@link User} de la session
     * @return SUCCESS
     */
    public String doLogOut() {
        this.session.remove("user");

        return ActionSupport.SUCCESS;
    }
}