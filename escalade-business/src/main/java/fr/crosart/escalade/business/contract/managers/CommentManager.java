package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.Comment;

import java.util.List;

public interface CommentManager {

    List<Comment> getListComment(Integer pSiteId);
    void insertComment(Comment pComment);

}
