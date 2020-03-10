package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.CommentDao;
import fr.crosart.escalade.consumer.mappers.CommentRowMapper;
import fr.crosart.escalade.model.beans.Comment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentDaoImpl extends AbstractDaoImpl implements CommentDao {

    @Override
    public List<Comment> getListComments(Integer pSiteId) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String vSQL = "SELECT * FROM escalade.comment WHERE siteid = " + pSiteId + " ORDER BY commentid DESC";

        return vJdbcTemplate.query(vSQL, new CommentRowMapper());

    }

}
