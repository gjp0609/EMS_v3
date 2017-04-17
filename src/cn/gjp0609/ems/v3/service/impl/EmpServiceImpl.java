package cn.gjp0609.ems.v3.service.impl;

import cn.gjp0609.ems.v3.dao.EmployeeDao;
import cn.gjp0609.ems.v3.entity.Employee;
import cn.gjp0609.ems.v3.entity.Page;
import cn.gjp0609.ems.v3.service.EmployeeService;
import cn.gjp0609.ems.v3.utils.MyBatisUtils;

import java.util.List;

/**
 * Created by gjp06 on 17.4.1.
 */
public class EmpServiceImpl implements EmployeeService {
//    private EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);

    @Override
    public List<Employee> queryAllEmp(Page page) {
        EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);
        List<Employee> list = null;
        try {
            int totalRows = employeeDao.selectTotalRows();
            page.setTotalRows(totalRows);
            list = employeeDao.selectEmpByCdt(new Employee(), page.getFirstRow(), page.getLastRow());
            if (list == null) throw new RuntimeException("查询无任何员工");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Employee queryEmpById(Integer id) {
        EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);
        List<Employee> employees = null;
        try {
            if (id == null) throw new RuntimeException("未收到员工 ID");
            Employee employee = new Employee();
            employee.setId(id);
            employees = employeeDao.selectEmpByCdt(employee, null, null);
            if (employees == null) throw new RuntimeException("未找到此员工");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return employees != null ? employees.get(0) : null;
    }


    @Override
    public int deleteEmp(Employee employee) {
        EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);
        int result = 0;
        try {
            if (employee == null) throw new RuntimeException("未收到要删除的员工");
            employee.setId(employee.getId());
            result = employeeDao.deleteEmpByCdt(employee);
            if (result != 1) throw new RuntimeException("删除员工失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateEmp(Employee employee) {
        EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);
        int result = 0;
        try {
            if (employee == null) throw new RuntimeException("未收到参数");
            result = employeeDao.updateEmp(employee);
            if (result != 1) throw new RuntimeException("更新员工失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addEmp(Employee employee) {
        EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);
        int result = 0;
        try {
            if (employee == null) throw new RuntimeException("未收到要添加的员工");
            result = employeeDao.addEmp(employee);
            if (result != 1) throw new RuntimeException("添加员工失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Employee> queryEmpByCdt(Employee employee) {
        return null;
    }

    @Override
    public int deleteEmps(List<Integer> ids) {
        EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);
        int result = 0;
        try {
            if (ids == null) throw new RuntimeException("未收到要删除的员工 id list");
            result = employeeDao.deleteEmpByIds(ids);
            if (result < 1) throw new RuntimeException("删除员工失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
