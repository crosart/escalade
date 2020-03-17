package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.TopoDao;
import fr.crosart.escalade.consumer.mappers.TopoRowMapper;
import fr.crosart.escalade.model.beans.Topo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
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
        String vSQL = "SELECT c.*, u.sitename, u.sitedepartment FROM escalade.topo c INNER JOIN escalade.site u ON u.siteid = c.siteid WHERE userid = " + pUserId + " ORDER BY topoid DESC";

        try {
            return vJdbcTemplate.query(vSQL, new TopoRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

}
