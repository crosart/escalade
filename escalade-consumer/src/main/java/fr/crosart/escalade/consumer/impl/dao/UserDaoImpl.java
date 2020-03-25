package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.UserDao;
import fr.crosart.escalade.consumer.mappers.UserRowMapper;
import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;

@Named
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

    /**
     * Renvoie l'{@link User} demandé
     * @param pId ID de l'{@link User}
     * @return {@link User}
     */

    @Override
    public User getUser(Integer pId) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM escalade.registereduser WHERE userid = " + pId;

        return vJdbcTemplate.queryForObject(vSQL, new UserRowMapper());

    }

    @Override
    public User logUser(String pLogin) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

            String vSQL = "SELECT * FROM escalade.registereduser WHERE userlogin = '" + pLogin + "'";

            return vJdbcTemplate.queryForObject(vSQL, new UserRowMapper());

    }

    @Override
    public void createUser(User pUser) {

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        String vSQL = "INSERT INTO escalade.registereduser (userpassword, usernickname, userfirstname, userlastname, usermail, usertelephone, userismember) " +
                "VALUES (:userpassword, :usernickname, :userfirstname, :userlastname, :usermail, :usertelephone, :userismember)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("userpassword", pUser.getPassword());
        vParams.addValue("usernickname", pUser.getNickname());
        vParams.addValue("userfirstname", pUser.getFirstName());
        vParams.addValue("userlastname", pUser.getLastName());
        vParams.addValue("usermail", pUser.getMail());
        vParams.addValue("usertelephone", pUser.getTelephone());
        vParams.addValue("userismember", pUser.isMember());

        vJdbcTemplate.update(vSQL, vParams);

    }
}
