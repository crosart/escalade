package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.Comment;

import java.util.List;

public interface CommentDao {

    List<Comment> getListComments(Integer pSiteId);
    void insertNewComment(Comment pComment);

}
