package fr.crosart.escalade.business.contract;

import fr.crosart.escalade.business.contract.managers.CommentManager;
import fr.crosart.escalade.business.contract.managers.SiteManager;
import fr.crosart.escalade.business.contract.managers.UserManager;

public interface ManagerFactory {
    SiteManager getSiteManager();
    UserManager getUserManager();
    CommentManager getCommentManager();

}
