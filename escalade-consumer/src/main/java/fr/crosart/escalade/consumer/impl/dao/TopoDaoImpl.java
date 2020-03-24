package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.TopoDao;
import fr.crosart.escalade.consumer.mappers.TopoListRowMapper;
import fr.crosart.escalade.consumer.mappers.TopoRowMapper;
import fr.crosart.escalade.model.beans.Topo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;

@Named
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    @Override
    public Topo getTopo(Integer pSiteId) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM escalade.topo WHERE siteid = " + pSiteId;

        try {
            return vJdbcTemplate.queryForObject(vSQL, new TopoRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public List<Topo> getListTopos(Integer pUserId) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT c.*, u.sitename, u.sitedepartment, v.usernickname FROM escalade.topo c INNER JOIN escalade.site u ON u.siteid = c.siteid " +
                "FULL OUTER JOIN escalade.registereduser v ON v.userid = c.reserveduserid WHERE c.userid = " + pUserId + " ORDER BY topoid DESC";

        try {
            return vJdbcTemplate.query(vSQL, new TopoListRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public void insertTopo(Integer pSiteId, Integer pUserId) {

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        String vSQL = "INSERT INTO escalade.topo (siteid, userid, topopublishingdate) VALUES (:siteid, :userid, :topopublishingdate)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("siteid", pSiteId);
        vParams.addValue("userid", pUserId);
        vParams.addValue("topopublishingdate", LocalDate.now());

        vJdbcTemplate.update(vSQL, vParams);

    }

    @Override
    public void reserveTopo(Integer pSiteId, Integer pUserId) {

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        String vSQL = "UPDATE escalade.topo SET reserveduserid = :reserveduserid, topoisreserved = :isreserved WHERE siteid = :siteid";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("reserveduserid", pUserId);
        vParams.addValue("siteid", pSiteId);
        vParams.addValue("isreserved", true);

        vJdbcTemplate.update(vSQL, vParams);

    }


}
