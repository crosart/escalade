package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.TopoDao;
import fr.crosart.escalade.consumer.mappers.TopoRowMapper;
import fr.crosart.escalade.model.beans.Topo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

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

}
