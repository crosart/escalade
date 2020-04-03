package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.Research;
import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.exceptions.NotFoundException;

import java.util.List;

public interface SiteDao {

    List<Site> getLastSites();

    List<Site> getSearchSites(String pSearch);

    List<Site> getSearchSites(Research pResearch);

    Site getSite(Integer pId) throws NotFoundException;

    void insertNewSite(Site pSite);

    List<Site> getSiteCountries();

    List<Site> getSiteDepartments();

    void setSiteOfficial(Integer pSiteId);
}
