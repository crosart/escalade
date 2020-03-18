package fr.crosart.escalade.consumer.mappers;

import fr.crosart.escalade.model.beans.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<Department> {

    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {

        Department department = new Department();

        department.setId(rs.getInt("department_id"));
        department.setCode(rs.getString("department_code"));
        department.setName(rs.getString("department_name"));

        return department;

    }

}
