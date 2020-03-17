package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.Topo;
import fr.crosart.escalade.model.exceptions.NotFoundException;

import java.util.List;

public interface TopoDao {

    Topo getTopo(Integer pSiteId);

    List<Topo> getListTopos(Integer pUserId);
}
