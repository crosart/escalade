package fr.crosart.escalade.business.impl.managers;

import fr.crosart.escalade.business.contract.managers.TopoManager;
import fr.crosart.escalade.consumer.contract.dao.TopoDao;
import fr.crosart.escalade.model.beans.Topo;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager  {

    @Inject
    private TopoDao topoDao;

    @Override
    public Topo getTopo(Integer pSiteId) {

        return topoDao.getTopo(pSiteId);

    }




}
