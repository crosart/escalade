package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.Topo;
import fr.crosart.escalade.model.exceptions.NotFoundException;

import java.util.List;

public interface TopoDao {

    Topo getTopo(Integer pSiteId);

    List<Topo> getListTopos(Integer pUserId);

    List<Topo> getListTopoSite(Integer pSiteId);

    void insertTopo(Integer pSiteId, Integer pUserId);

    void reserveTopo(Integer pTopoId, Integer pUserId);

    void acceptTopo(Integer pTopoId);

    void unlockTopo(Integer pTopoId);
}
