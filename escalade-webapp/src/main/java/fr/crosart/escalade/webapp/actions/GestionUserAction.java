package fr.crosart.escalade.webapp.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.beans.Topo;
import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@Named("gestionUserAction")
public class GestionUserAction extends ActionSupport {
    // ===== Attributs
    @Inject
    private ManagerFactory managerFactory;

    // -- Entrée
    private Integer id;

    // -- Sortie
    private List<User> listUser;
    private User user;
    private List<Topo> listTopo;

    // ===== Getters & Setters
    public void setId(Integer id) {
        this.id = id;
    }
    public List<User> getListUser() {
        return listUser;
    }
    public void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User pUser) {
        user = pUser;
    }
    public List<Topo> getListTopo() {
        return listTopo;
    }

    // ===== Méthodes
    public String doList() {
        listUser = managerFactory.getUserManager().getListUser();
        return ActionSupport.SUCCESS;
    }

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

}
