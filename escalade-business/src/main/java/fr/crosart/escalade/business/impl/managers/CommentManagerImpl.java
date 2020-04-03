package fr.crosart.escalade.business.impl.managers;

import fr.crosart.escalade.business.contract.managers.CommentManager;
import fr.crosart.escalade.consumer.contract.dao.CommentDao;
import fr.crosart.escalade.model.beans.Comment;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CommentManagerImpl extends AbstractManager implements CommentManager {

    @Inject
    private CommentDao commentDao;

    @Override
    public List<Comment> getListComment(Integer pSiteId) {
        return commentDao.getListComments(pSiteId);
    }

    @Override
    public Comment getComment(Integer pCommentId) {
        return commentDao.getComment(pCommentId);
    }

    @Override
    public void insertComment(Comment pComment) {
        commentDao.insertNewComment(pComment);
    }

    @Override
    public void deleteComment(Integer pCommentId) {
        commentDao.deleteComment(pCommentId);
    }

    @Override
    public void modifyComment(String pContent, Integer pCommentId) {
        commentDao.modifyComment(pContent, pCommentId);
    }

}
