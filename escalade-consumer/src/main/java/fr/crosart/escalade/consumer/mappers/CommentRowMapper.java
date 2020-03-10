package fr.crosart.escalade.consumer.mappers;

import fr.crosart.escalade.model.beans.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {

        Comment comment = new Comment();

        comment.setId(rs.getInt("commentid"));
        comment.setUserId(rs.getInt("userid"));
        comment.setSiteId(rs.getInt("siteid"));
        comment.setContent(rs.getString("commentcontent"));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        comment.setDate(LocalDate.parse(rs.getString("commentdate"), dateFormatter));

        return comment;

    }

}
