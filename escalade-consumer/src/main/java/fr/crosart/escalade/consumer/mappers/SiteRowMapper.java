package fr.crosart.escalade.consumer.mappers;

import fr.crosart.escalade.model.beans.Site;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SiteRowMapper implements RowMapper<Site> {

    @Override
    public Site mapRow(ResultSet rs, int rowNum) throws SQLException {

        Site site = new Site();

        site.setId(rs.getInt("siteid"));
        site.setName(rs.getString("sitename"));
        site.setCountry(rs.getString("sitecountry"));
        site.setDepartment(rs.getString("sitedepartment"));
        site.setLatitude(rs.getString("sitelatitude"));
        site.setLongitude(rs.getString("sitelongitude"));
        site.setHeight(rs.getString("siteheight"));
        site.setTracks(rs.getString("sitetracks"));
        site.setCotationMin(rs.getString("sitecotationmin"));
        site.setCotationMax(rs.getString("sitecotationmax"));
        site.setDescription(rs.getString("sitedescription"));
        site.setOfficial(rs.getBoolean("siteisofficial"));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        site.setCreationDate(LocalDate.parse(rs.getString("sitecreationdate"), dateFormatter));

        return site;

    }

}
