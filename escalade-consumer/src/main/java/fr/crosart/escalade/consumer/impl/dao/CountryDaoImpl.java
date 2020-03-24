package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.CountryDao;
import fr.crosart.escalade.consumer.mappers.CountryRowMapper;
import fr.crosart.escalade.consumer.mappers.DepartmentRowMapper;
import fr.crosart.escalade.model.beans.Country;
import fr.crosart.escalade.model.beans.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class CountryDaoImpl extends AbstractDaoImpl implements CountryDao {

    @Override
    public List<Country> getListCountries() {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM escalade.countries ORDER BY country_id";

        return vJdbcTemplate.query(vSQL, new CountryRowMapper());

    }

}
