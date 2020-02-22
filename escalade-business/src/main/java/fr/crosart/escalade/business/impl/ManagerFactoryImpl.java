package fr.crosart.escalade.business.impl;

import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.business.contract.managers.SiteManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private SiteManager projetManager;

    @Override
    public SiteManager getSiteManager() {
        return this.projetManager;
    }

    public void setProjetManager(SiteManager pProjetManager) {
        projetManager = pProjetManager;
    }
}
