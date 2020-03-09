package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.SiteDao;
import fr.crosart.escalade.consumer.mappers.SiteRowMapper;
import fr.crosart.escalade.model.beans.Site;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {



    @Override
    public List<Site> getLastSites() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query("SELECT siteid,sitename,sitecountry FROM escalade.site ORDER BY siteid DESC LIMIT 5",new RowMapper<Site>() {

            @Override
            public Site mapRow(ResultSet rs, int rownumber) throws SQLException {
                Site e = new Site();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setCountry(rs.getString(3));
                return e;
            }

        });
    }

    @Override
    public Site getSite(Integer pId) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String sql = "SELECT * FROM escalade.site WHERE siteid = " + pId;

        return vJdbcTemplate.queryForObject(sql, new SiteRowMapper());

    }





    @Override
    public void insertNewSite(Site pSite) {

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        String vSQL = "INSERT INTO escalade.site (sitename, sitecountry, sitedepartment, sitelatitude, sitelongitude, siteheight, sitetracks, sitecotationmin, sitecotationmax, sitedescription, siteisofficial, sitecreationdate)" +
                " VALUES (:sitename,:sitecountry,:sitedepartment,:sitelatitude,:sitelongitude,:siteheight,:sitetracks,:sitecotationmin,:sitecotationmax,:sitedescription,:siteisofficial,:sitecreationdate)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

       // vParams.addValue("siteid", null);
        vParams.addValue("sitename", pSite.getName());
        vParams.addValue("sitecountry", pSite.getCountry());
        vParams.addValue("sitedepartment", pSite.getDepartment());
        vParams.addValue("sitelatitude", pSite.getLatitude());
        vParams.addValue("sitelongitude", pSite.getLongitude());
        vParams.addValue("siteheight", pSite.getHeight());
        vParams.addValue("sitetracks", pSite.getTracks());
        vParams.addValue("sitecotationmin", pSite.getCotationMin());
        vParams.addValue("sitecotationmax", pSite.getCotationMax());
        vParams.addValue("sitedescription", pSite.getDescription());
        vParams.addValue("siteisofficial", pSite.isOfficial());
        vParams.addValue("sitecreationdate", pSite.getCreationDate());

        vJdbcTemplate.update(vSQL, vParams);

    }
}