package fr.crosart.escalade.consumer.mappers;

import fr.crosart.escalade.model.beans.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();

        user.setId(rs.getInt("userid"));
        user.setLogin(rs.getString("userlogin"));
        user.setPassword(rs.getString("userpassword"));
        user.setNickname(rs.getString("usernickname"));
        user.setFirstName(rs.getString("userfirstname"));
        user.setLastName(rs.getString("userlastname"));
        user.setMail(rs.getString("usermail"));
        user.setTelephone(rs.getString("usertelephone"));
        user.setMember(rs.getBoolean("userismember"));

        return user;

    }

}
