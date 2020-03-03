package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.Site;

import java.util.List;

public interface SiteDao {

    List<Site> getLastSites();
    void insertNewSite(Site pSite);

}
