package fr.crosart.escalade.webapp.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.Site;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@Named("gestionSiteAction")
public class GestionSiteAction extends ActionSupport {
    // ===== Attributs
    @Inject
    private ManagerFactory managerFactory;

    // -- Entrée
    private Integer id;

    // -- Sortie
    private List<Site> listSite;

    // ===== Getters & Setters
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Site> getListSite() {
        return listSite;
    }
    public void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }

    // ===== Méthodes
    public String doList() {
        listSite = managerFactory.getSiteManager().getListSite();
        return ActionSupport.SUCCESS;
    }

}
