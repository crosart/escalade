package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.Research;
import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.exceptions.NotFoundException;

import java.util.List;

public interface SiteManager {

    List<Site> getListSite();

    List<Site> getListSite(Research pResearch);

    Site getDetailSite(Integer pId) throws NotFoundException;

    void insertSite(Site pSite);

    List<Site> getSiteCountries();

    List<Site> getSiteDepartments();

    void setSiteOfficial(Integer pSiteId);
}
