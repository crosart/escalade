package fr.crosart.escalade.business.impl.managers;

import fr.crosart.escalade.business.contract.managers.DepartmentManager;
import fr.crosart.escalade.consumer.contract.dao.DepartmentDao;
import fr.crosart.escalade.model.beans.Department;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DepartmentManagerImpl extends AbstractManager implements DepartmentManager {

    @Inject
    DepartmentDao departmentDao;

    @Override
    public List<Department> getListDepartments() {
        return departmentDao.getListDepartments();
    }

}
