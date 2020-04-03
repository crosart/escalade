package fr.crosart.escalade.webapp.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.User;
import org.apache.struts2.dispatcher.Parameter;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named("gestionTopoAction")
public class GestionTopoAction extends ActionSupport implements SessionAware {

    @Inject
    private ManagerFactory managerFactory;

    private Map<String, Object> session;
    private User vUser;
    private Parameter pId;
    private Integer id;
    private Integer userId;
    private Integer topoId;
    private Integer siteId;

    public String doClaim() {

        vUser = (User) this.session.get("user");

        managerFactory.getTopoManager().insertTopo(id, vUser.getId());

        return ActionSupport.SUCCESS;
    }

    public String doReserve() {

        vUser = (User) this.session.get("user");


        managerFactory.getTopoManager().reserveTopo(topoId, vUser.getId());

        return ActionSupport.SUCCESS;

    }

    public String doAccept() {

        vUser = (User) this.session.get("user");
        userId = vUser.getId();
        managerFactory.getTopoManager().acceptTopo(id);

        return ActionSupport.SUCCESS;

    }

    public String doUnlock() {

        vUser = (User) this.session.get("user");
        userId = vUser.getId();
        managerFactory.getTopoManager().unlockTopo(id);

        return ActionSupport.SUCCESS;

    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    public User getvUser() {
        return vUser;
    }
    public void setvUser(User vUser) {
        this.vUser = vUser;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getTopoId() {
        return topoId;
    }
    public void setTopoId(Integer topoId) {
        this.topoId = topoId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
