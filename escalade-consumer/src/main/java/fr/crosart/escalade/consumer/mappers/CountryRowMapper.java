package fr.crosart.escalade.consumer.mappers;

import fr.crosart.escalade.model.beans.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CountryRowMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {

        Country country = new Country();

        country.setId(rs.getInt("country_id"));
        country.setCode(rs.getString("country_code"));
        country.setName(rs.getString("country_name"));

        return country;

    }

}
