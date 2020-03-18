package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> getListDepartments();
}
