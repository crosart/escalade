package fr.crosart.escalade.webapp.actions;

import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.beans.Topo;
import fr.crosart.escalade.model.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named("gestionTopoAction")
public class GestionTopoAction extends ActionSupport implements SessionAware {

    @Inject
    private ManagerFactory managerFactory;

    private User vUser;
    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Getter private Integer userId;

    @Setter private Integer topoId;

    @Getter @Setter private Integer siteId;
    @Getter @Setter private Integer id;

    /**
     * Action > Ajoute un {@link Topo} appartenant à l'{@link User} connecté pour le {@link Site} affiché
     * @return Action Struts2
     */
    public String doClaim() {
        vUser = (User) this.session.get("user");
        managerFactory.getTopoManager().insertTopo(id, vUser.getId());

        return ActionSupport.SUCCESS;
    }

    /**
     * Action > Demande la réservation du {@link Topo} sélectionné
     * @return Action Struts2
     */
    public String doReserve() {
        vUser = (User) this.session.get("user");
        managerFactory.getTopoManager().reserveTopo(topoId, vUser.getId());

        return ActionSupport.SUCCESS;
    }

    /**
     * Action > Accepte la réservation du {@link Topo} sélectionné
     * @return Action Struts2
     */
    public String doAccept() {
        vUser = (User) this.session.get("user");
        userId = vUser.getId();
        managerFactory.getTopoManager().acceptTopo(topoId);

        return ActionSupport.SUCCESS;
    }

    /**
     * Action > Libère la réservation du {@link Topo} sélectionné
     * @return Action Struts 2
     */
    public String doUnlock() {
        vUser = (User) this.session.get("user");
        userId = vUser.getId();
        managerFactory.getTopoManager().unlockTopo(id);

        return ActionSupport.SUCCESS;
    }
}