package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.exceptions.FunctionalException;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import fr.crosart.escalade.model.exceptions.TechnicalException;

import java.util.List;

public interface SiteManager {

    /**
     * Renvoie la liste des {@link Site}
     * @return List
     */
    List<Site> getListSite();

    /**
     * Renvoie le projet demandé
     * @param pId (ID du site)
     * @return {@link Site}
     * @throws NotFoundException Si le site n'existe pas
     */
    Site getSite(Integer pId) throws NotFoundException;

    /**
     * Ajoute un nouveau site
     * @param pSite -
     * @throws FunctionalException Site invalide
     * @throws TechnicalException Erreur technique
     */

    void insertSite(Site pSite);

    Site getDetailSite(Integer pId) throws NotFoundException;

}
