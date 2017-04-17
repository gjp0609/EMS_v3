package cn.gjp0609.ems.v3.test;

import cn.gjp0609.ems.v3.dao.EmployeeDao;
import cn.gjp0609.ems.v3.entity.Employee;
import cn.gjp0609.ems.v3.utils.MyBatisUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjp06 on 17.4.14.
 */
class TestEmpDao {
    private EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);

    @Test
    void selectEmp() {
        Employee employee = new Employee();
//        employee.setSex("女");
//        employee.setId(100003);
//        employee.setDepartment(new Department(20, null,null));
//        employee.setDepartment(new Department(null, "后勤部", null));
        List<Employee> employees = employeeDao.selectEmpByCdt(employee, 4, 5);
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    @Test
    void deleteEmp() {
        Employee employee = new Employee();
        employee.setSex("女");
//        employee.setId(100002);
//        employee.setDepartment(new Department(10, null, null));
        int i = employeeDao.deleteEmpByCdt(employee);
        System.out.println(i);
        MyBatisUtils.rollback();
    }

    @Test
    void testUpdate() {
        Employee employee = new Employee();
        employee.setId(100011);
//        employee.setSex("女");
        employee.setSalary(1236d);
//        employee.setDepartment(new Department(10, null, null));
        int i = employeeDao.updateEmp(employee);
        this.selectEmp();
        MyBatisUtils.rollback();
    }


    @Test
    void Rows() {
        int i = employeeDao.selectTotalRows();
        System.out.println(i);
    }

    @Test
    void deleteEmps() {
        List<Integer> list = new ArrayList<>();
        list.add(100003);
        list.add(100004);
        list.add(100005);
        list.add(100006);
        list.add(100007);
        int i = employeeDao.deleteEmpByIds(list);
        System.out.println(i);
        MyBatisUtils.rollback();
    }
}
