package fr.crosart.escalade.business.impl.managers;

import fr.crosart.escalade.business.contract.managers.TopoManager;
import fr.crosart.escalade.consumer.contract.dao.TopoDao;
import fr.crosart.escalade.model.beans.Topo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager  {

    @Inject
    private TopoDao topoDao;

    @Override
    public Topo getTopo(Integer pSiteId) {

        return topoDao.getTopo(pSiteId);

    }

    @Override
    public List<Topo> getListTopos(Integer pUserId) {
        return topoDao.getListTopos(pUserId);
    }

    @Override
    public void insertTopo(Integer pSiteId, Integer pUserId) {
        topoDao.insertTopo(pSiteId, pUserId);
    }

    @Override
    public void reserveTopo(Integer pTopoId, Integer pUserId) {
        topoDao.reserveTopo(pTopoId, pUserId);
    }

    @Override
    public void acceptTopo(Integer pTopoId) {
        topoDao.acceptTopo(pTopoId);
    }

    @Override
    public void unlockTopo(Integer pTopoId) {
        topoDao.unlockTopo(pTopoId);
    }

    @Override
    public List<Topo> getListTopoSite(Integer pSiteId) {

        return topoDao.getListTopoSite(pSiteId);

    }


}
