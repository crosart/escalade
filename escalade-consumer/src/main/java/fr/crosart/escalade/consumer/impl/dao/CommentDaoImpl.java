package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.CommentDao;
import fr.crosart.escalade.consumer.mappers.CommentRowMapper;
import fr.crosart.escalade.model.beans.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentDaoImpl extends AbstractDaoImpl implements CommentDao {

    @Override
    public List<Comment> getListComments(Integer pSiteId) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String vSQL = "SELECT c.*, u.usernickname FROM escalade.comment c INNER JOIN escalade.registereduser u ON u.userid = c.userid WHERE siteid = " + pSiteId + " ORDER BY commentid DESC";

        return vJdbcTemplate.query(vSQL, new CommentRowMapper());

    }

    @Override
    public Comment getComment(Integer pCommentId) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String vSQL = "SELECT c.*, u.usernickname FROM escalade.comment c INNER JOIN escalade.registereduser u ON u.userid = c.userid WHERE commentid = " + pCommentId;

        return vJdbcTemplate.queryForObject(vSQL, new CommentRowMapper());

    }

    @Override
    public void insertNewComment(Comment pComment) {

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        String vSQL = "INSERT INTO escalade.comment (userid, siteid, commentcontent, commentdate) VALUES (:userid, :siteid, :commentcontent, :commentdate)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("userid", pComment.getUserId());
        vParams.addValue("siteid", pComment.getSiteId());
        vParams.addValue("commentcontent", pComment.getContent());
        vParams.addValue("commentdate", pComment.getDate());

        vJdbcTemplate.update(vSQL, vParams);

    }

    @Override
    public void deleteComment(Integer pCommentId) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "DELETE FROM escalade.comment WHERE commentid = " + pCommentId;

        vJdbcTemplate.update(vSQL);

    }

    @Override
    public void modifyComment(String pContent, Integer pCommentId) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "UPDATE escalade.comment SET commentcontent = '" + pContent + "' WHERE commentid = " + pCommentId;

        vJdbcTemplate.update(vSQL);

    }

}
