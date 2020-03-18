package fr.crosart.escalade.business.contract;

import fr.crosart.escalade.business.contract.managers.*;

public interface ManagerFactory {

    SiteManager getSiteManager();
    UserManager getUserManager();
    CommentManager getCommentManager();
    TopoManager getTopoManager();
    DepartmentManager getDepartmentManager();

}
