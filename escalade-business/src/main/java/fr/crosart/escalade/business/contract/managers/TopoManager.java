package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.Topo;

import java.util.List;

public interface TopoManager {
    Topo getTopo(Integer pSiteId);

    List<Topo> getListTopos(Integer pUserId);
}
