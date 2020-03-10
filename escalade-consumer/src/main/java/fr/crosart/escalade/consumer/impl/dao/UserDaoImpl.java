package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.UserDao;
import fr.crosart.escalade.consumer.mappers.UserRowMapper;
import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
