package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.Comment;

import java.util.List;

public interface CommentDao {

    List<Comment> getListComments(Integer pSiteId);

    Comment getComment(Integer pCommentId);

    void insertNewComment(Comment pComment);

    void deleteComment(Integer pCommentId);

    void modifyComment(String pContent, Integer pCommentId);
}
