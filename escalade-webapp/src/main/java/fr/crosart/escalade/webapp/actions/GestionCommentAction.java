package fr.crosart.escalade.webapp.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.Comment;
import fr.crosart.escalade.model.beans.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Map;

@Named("gestionCommentAction")
public class GestionCommentAction extends ActionSupport implements SessionAware {

    @Inject
    private ManagerFactory managerFactory;

    @Inject
    private Comment comment;

    private String content;
    private Integer userId;
    private Integer siteId;
    private User vUser;

    private Map<String, Object> session;


    public String doCreate() {
        LocalDate vDate = LocalDate.now();

        if (!StringUtils.isEmpty(content)) {
            try {

                comment.setContent(content);
                vUser = (User) this.session.get("user");
                comment.setUserId(vUser.getId());
                comment.setSiteId(siteId);
                comment.setDate(vDate);

                managerFactory.getCommentManager().insertComment(comment);

            } catch (Exception vEx) {
                vEx.printStackTrace();
                this.addActionError("Erreur lors de l'ajout !");
            }

    }

        return ActionSupport.SUCCESS;

}

    public void setComment(Comment comment) {
        this.comment = comment;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }
}