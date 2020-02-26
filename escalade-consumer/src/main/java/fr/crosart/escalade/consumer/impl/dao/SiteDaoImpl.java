package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.SiteDao;
import fr.crosart.escalade.model.beans.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {



    @Override
    public List<Site> getLastSites() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query("SELECT siteid,sitename,sitecountry FROM escalade.site ORDER BY siteid DESC LIMIT 2",new RowMapper<Site>() {

            @Override
            public Site mapRow(ResultSet rs, int rownumber) throws SQLException {
                Site e=new Site();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setCountry(rs.getString(3));
                return e;
            }

        });
    }
}