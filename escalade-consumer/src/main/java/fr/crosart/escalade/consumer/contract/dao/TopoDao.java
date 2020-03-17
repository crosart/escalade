package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.Topo;
import fr.crosart.escalade.model.exceptions.NotFoundException;

public interface TopoDao {

    Topo getTopo(Integer pSiteId);

}
