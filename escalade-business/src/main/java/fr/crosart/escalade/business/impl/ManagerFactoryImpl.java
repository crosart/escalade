package fr.crosart.escalade.business.impl;

import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.business.contract.managers.*;

import javax.inject.Inject;
import javax.inject.Named;

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private SiteManager siteManager;

    @Override
    public SiteManager getSiteManager() {
        return this.siteManager;
    }

    @Inject
    private UserManager userManager;

    @Override
    public UserManager getUserManager() {
        return this.userManager;
    }

    @Inject
    private CommentManager commentManager;

    @Override
    public CommentManager getCommentManager() {
        return this.commentManager;
    }

    @Inject
    private TopoManager topoManager;

    @Override
    public TopoManager getTopoManager() {
        return this.topoManager;
    }

    @Inject
    private DepartmentManager departmentManager;

    @Override
    public DepartmentManager getDepartmentManager() {
        return this.departmentManager;
    }

    @Inject
    private CountryManager countryManager;

    @Override
    public CountryManager getCountryManager() {
        return this.countryManager;
    }
}
