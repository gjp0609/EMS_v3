package cn.gjp0609.ems.v3.test;

import cn.gjp0609.ems.v3.dao.DepartmentDao;
import cn.gjp0609.ems.v3.dao.EmployeeDao;
import cn.gjp0609.ems.v3.entity.Department;
import cn.gjp0609.ems.v3.entity.Employee;
import cn.gjp0609.ems.v3.utils.MyBatisUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by gjp06 on 17.4.16.
 */
public class TestDeptDao {
    private DepartmentDao departmentDao = MyBatisUtils.getMapper(DepartmentDao.class);
    private EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);


    @Test
    void testSelect() {

        List<Department> departments = departmentDao.selectDeptByCdt(new Department());
        for (Department d : departments) {
            System.out.println(d);
        }
    }

    @Test
    void testDelete() {
        Department department = new Department();
        Employee employee = new Employee();
        employee.setDepartment(new Department(10, null, null));
        employeeDao.deleteEmpByCdt(employee);

        department.setId(10);
        int i = departmentDao.deleteDept(department);
        System.out.println(i);
        MyBatisUtils.rollback();
    }

    @Test
    void testAdd() {
        int i = departmentDao.addDept(new Department(60, "123", null));

        System.out.println(i);
        MyBatisUtils.rollback();
    }

    @Test
    void testUpdate() {
        int i = departmentDao.updateDept(new Department(10, "123", null));
        System.out.println(i);
        MyBatisUtils.rollback();
    }
}
