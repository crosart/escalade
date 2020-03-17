package fr.crosart.escalade.business.impl;

import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.business.contract.managers.CommentManager;
import fr.crosart.escalade.business.contract.managers.SiteManager;
import fr.crosart.escalade.business.contract.managers.TopoManager;
import fr.crosart.escalade.business.contract.managers.UserManager;

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
    public void setSiteManager(SiteManager pSiteManager) {
        siteManager = pSiteManager;
    }

    @Inject
    private UserManager userManager;

    @Override
    public UserManager getUserManager() {
        return this.userManager;
    }
    public void setUserManager(UserManager pUserManager) {
        userManager = pUserManager;
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

    public void setCommentManager(CommentManager pCommentManager) {
        commentManager = pCommentManager;
    }

}
