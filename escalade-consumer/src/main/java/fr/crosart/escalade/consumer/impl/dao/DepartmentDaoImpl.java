package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.DepartmentDao;
import fr.crosart.escalade.consumer.mappers.DepartmentRowMapper;
import fr.crosart.escalade.model.beans.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class DepartmentDaoImpl extends AbstractDaoImpl implements DepartmentDao {

    @Override
    public List<Department> getListDepartments() {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSql = "SELECT * FROM escalade.departments ORDER BY department_id";

        return vJdbcTemplate.query(vSql, new DepartmentRowMapper());

    }

}
