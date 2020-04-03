package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.Comment;

import java.util.List;

public interface CommentManager {

    List<Comment> getListComment(Integer pSiteId);

    Comment getComment(Integer pCommentId);

    void insertComment(Comment pComment);

    void deleteComment(Integer pCommentId);

    void modifyComment(String pContent, Integer pCommentId);
}
