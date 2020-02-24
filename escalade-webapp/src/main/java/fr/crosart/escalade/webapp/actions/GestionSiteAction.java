package fr.crosart.escalade.webapp.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.exceptions.NotFoundException;

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
    private Site site;

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
    public Site getSite() {
        return site;
    }
    public void setSite(Site pSite) {
        site = pSite;
    }

    // ===== Méthodes
    public String doList() {
        listSite = managerFactory.getSiteManager().getListSite();
        return ActionSupport.SUCCESS;
    }

    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.site.missing.id"));
        } else {
            try {
                site = managerFactory.getSiteManager().getSite(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.site.notfound", Collections.singletonList(id)));
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

}
