package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.Comment;

import java.util.List;

public interface CommentManager {

    void insertComment(Comment pComment);

    void modifyComment(String pContent, Integer pCommentId);

    void deleteComment(Integer pCommentId);

    Comment getComment(Integer pCommentId);

    List<Comment> getCommentsList(Integer pSiteId);

}
