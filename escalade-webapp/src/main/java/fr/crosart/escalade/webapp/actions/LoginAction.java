package fr.crosart.escalade.webapp.actions;


import com.opensymphony.xwork2.ActionSupport;
import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import java.util.Map;

/**
 * Action de gestion de la connexion/déconnexion d'un utilisateur
 */
public class LoginAction extends ActionSupport implements SessionAware {


    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    // ----- Paramètres en entrée
    private String login;
    private String password;

    // ----- Eléments Struts
    private Map<String, Object> session;


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

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


    // ==================== Méthodes ====================
    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     */
    public String doLogin() throws NotFoundException {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(login, password)) {
                try {

                    User vUser = managerFactory.getUserManager().logUser(login);

                    if (password.equals(vUser.getPassword())) {

                        // Ajout de l'utilisateur en session
                        this.session.put("user", vUser);

                        vResult = ActionSupport.SUCCESS;

                    } else {

                        this.addActionError("Identifiant ou mot de passe invalide !");

                    }
                } catch (Exception vEx) {
                    this.addActionError("Identifiant inconnu");
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
}
