package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.exceptions.NotFoundException;

import java.util.List;

public interface SiteManager {

    /**
     * Renvoie la liste des {@link Site}
     * @return List
     */

    List<Site> getListSite();

    /**
     * Renvoie le {@link Site} demandé
     * @param pId (ID du site)
     * @return {@link Site}
     * @throws NotFoundException Si le site n'existe pas
     */

    Site getDetailSite(Integer pId) throws NotFoundException;

    /**
     * Ajoute un nouveau site
     * @param pSite -
     */

    void insertSite(Site pSite);

}
