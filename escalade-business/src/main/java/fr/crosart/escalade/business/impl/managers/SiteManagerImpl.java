package fr.crosart.escalade.business.impl.managers;

import fr.crosart.escalade.business.contract.managers.SiteManager;
import fr.crosart.escalade.consumer.contract.dao.SiteDao;
import fr.crosart.escalade.model.beans.Research;
import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.exceptions.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {

    @Inject
    private SiteDao siteDao;

    @Override
    public List<Site> getListSite() {

        return siteDao.getLastSites();

    }

    @Override
    public List<Site> getListSite(String pSearch) {

        return siteDao.getSearchSites(pSearch);

    }

    @Override
    public List<Site> getListSite(Research pResearch) {
        return siteDao.getSearchSites(pResearch);
    }

    @Override
    public Site getDetailSite(Integer pId) throws NotFoundException {
        return siteDao.getSite(pId);
    }

    @Override
    public void insertSite(Site pSite) {
        siteDao.insertNewSite(pSite);
    }

    @Override
    public List<Site> getSiteCountries() {
        return siteDao.getSiteCountries();
    }

    @Override
    public List<Site> getSiteDepartments() {
        return siteDao.getSiteDepartments();
    }

}
