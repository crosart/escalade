package fr.crosart.escalade.webapp.actions;

import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.Comment;
import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.beans.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.Parameter;
import java.time.LocalDate;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named("gestionCommentAction")
public class GestionCommentAction extends ActionSupport implements SessionAware {

    @Inject private ManagerFactory managerFactory;

    @Inject @Getter private Comment comment;

    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Getter @Setter private Integer siteId;

    @Getter private Parameter paramSiteId;

    @Setter private String content;
    @Setter private Integer commentId;
    @Setter private boolean commentStatus = false;

    /**
     * Action > Ajoute un {@link Comment} sur le {@link Site} affiché
     * @return Action Struts2
     */
    public String doCreate() {
        LocalDate vDate = LocalDate.now();
        String vResult = ActionSupport.INPUT;
        paramSiteId = ActionContext.getContext().getParameters().get("siteId");
        User vUser = (User) this.session.get("user");
        if (!StringUtils.isEmpty(content) && vUser.isMember()) {
            try {
                comment.setContent(content);
                comment.setUserId(vUser.getId());
                comment.setSiteId(siteId);
                comment.setDate(vDate);
                managerFactory.getCommentManager().insertComment(comment);

                vResult = ActionSupport.SUCCESS;
            } catch (Exception vEx) {
                vEx.printStackTrace();
                this.addActionError("Erreur lors de l'ajout !");
                vResult = ActionSupport.ERROR;
                return vResult;
            }
        }
        return vResult;
    }

    /**
     * Action > Modifie le {@link Comment} choisi
     * @return Action Struts2
     */
    public String doModify() {
        String vResult = ActionSupport.INPUT;
        comment = managerFactory.getCommentManager().getComment(commentId);
        if (commentStatus) {
            try {
                managerFactory.getCommentManager().modifyComment(content, commentId);

                vResult = ActionSupport.SUCCESS;
            } catch (Exception vEx) {
                vEx.printStackTrace();
                this.addActionError("Erreur lors de l'ajout !");
            }
        }
        return vResult;
    }

    /**
     * Action > Supprime le {@link Comment} choisi
     * @return Action Struts2
     */
    public String doDelete() {
        managerFactory.getCommentManager().deleteComment(commentId);
        return ActionSupport.SUCCESS;
    }
}