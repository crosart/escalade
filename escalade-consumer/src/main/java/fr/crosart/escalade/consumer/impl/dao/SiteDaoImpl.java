package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.SiteDao;
import fr.crosart.escalade.consumer.mappers.SiteRowMapper;
import fr.crosart.escalade.model.beans.Research;
import fr.crosart.escalade.model.beans.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {

    /**
     * Renvoie la liste des 5 derniers {@link Site} ajoutés
     * @return List
     */

    @Override
    public List<Site> getLastSites() {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSql = "SELECT * FROM escalade.site ORDER BY siteid DESC LIMIT 6";

        return vJdbcTemplate.query(vSql, new SiteRowMapper());

    }

    @Override
    public List<Site> getSearchSites(String pSearch) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSql = "SELECT * FROM escalade.site WHERE sitename ILIKE '%" + pSearch +"%' " +
                "OR sitecountry ILIKE '%" + pSearch +"%' " +
                "OR sitedepartment ILIKE '%" + pSearch +"%' " +
                "OR sitecotationmin ILIKE '%" + pSearch +"%' " +
                "OR sitecotationmax ILIKE '%" + pSearch +"%' ";

        return vJdbcTemplate.query(vSql, new SiteRowMapper());

    }

    @Override
    public List<Site> getSearchSites(Research pResearch) {

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        StringBuilder vSQL = new StringBuilder("SELECT * FROM escalade.site WHERE sitecotationmin >= :sitecotationmin AND sitecotationmax <= :sitecotationmax");
        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("sitecotationmin", pResearch.getCotationMin());
        vParams.addValue("sitecotationmax", pResearch.getCotationMax());

        if (!pResearch.getTextSearch().equals("")) {
            vSQL.append(" AND sitename ILIKE :textsearch");
            vParams.addValue("textsearch", "%" + pResearch.getTextSearch() + "%");
        }

        if (!pResearch.getCountry().equals("Pays")) {
            vSQL.append(" AND sitecountry = :sitecountry");
            vParams.addValue("sitecountry", pResearch.getCountry());
        }

        if (!pResearch.getDepartment().equals("Département")) {
            vSQL.append(" AND sitedepartment = :sitedepartment");
            vParams.addValue("sitedepartment", pResearch.getDepartment());
        }

        return vJdbcTemplate.query(vSQL.toString(), vParams, new SiteRowMapper());

    }

    /**
     * Renvoie le {@link Site} demandé
     * @param pId (ID du Site)
     * @return {@link Site}
     */

    @Override
    public Site getSite(Integer pId) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSql = "SELECT * FROM escalade.site WHERE siteid = " + pId;

        return vJdbcTemplate.queryForObject(vSql, new SiteRowMapper());

    }

    /**
     * Insère le {@link Site} renseigné dans lme formulaire
     * @param pSite -
     */

    @Override
    public void insertNewSite(Site pSite) {

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        String vSQL = "INSERT INTO escalade.site (sitename, sitecountry, sitedepartment, sitelatitude, sitelongitude, siteheight, sitetracks, sitecotationmin, sitecotationmax, sitedescription, siteisofficial, sitecreationdate)" +
                " VALUES (:sitename,:sitecountry,:sitedepartment,:sitelatitude,:sitelongitude,:siteheight,:sitetracks,:sitecotationmin,:sitecotationmax,:sitedescription,:siteisofficial,:sitecreationdate)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

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

    @Override
    public List<Site> getSiteCountries() {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT DISTINCT sitecountry FROM escalade.site WHERE sitecountry IS NOT NULL";
        RowMapper<Site> vRowMapper = new RowMapper<Site>() {
            public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
                Site vSite = new Site();
                vSite.setCountry(rs.getString("sitecountry"));
                return vSite;
            }
        };

        return vJdbcTemplate.query(vSQL, vRowMapper);

    }

    @Override
    public List<Site> getSiteDepartments() {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT DISTINCT sitedepartment FROM escalade.site WHERE sitedepartment IS NOT NULL";
        RowMapper<Site> vRowMapper = new RowMapper<Site>() {
            public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
                Site vSite = new Site();
                vSite.setDepartment(rs.getString("sitedepartment"));
                return vSite;
            }
        };

        return vJdbcTemplate.query(vSQL, vRowMapper);

    }
}