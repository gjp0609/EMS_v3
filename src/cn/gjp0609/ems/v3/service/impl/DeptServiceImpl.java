package cn.gjp0609.ems.v3.service.impl;

import cn.gjp0609.ems.v3.dao.DepartmentDao;
import cn.gjp0609.ems.v3.dao.EmployeeDao;
import cn.gjp0609.ems.v3.entity.Department;
import cn.gjp0609.ems.v3.entity.Employee;
import cn.gjp0609.ems.v3.service.DepartmentService;
import cn.gjp0609.ems.v3.utils.MyBatisUtils;

import java.util.List;

/**
 * Created by gjp06 on 17.4.16.
 */
public class DeptServiceImpl implements DepartmentService {

//    private DepartmentDao departmentDao = MyBatisUtils.getMapper(DepartmentDao.class);

    @Override
    public List<Department> queryAllDept() {
        DepartmentDao departmentDao = MyBatisUtils.getMapper(DepartmentDao.class);
        List<Department> depts = null;
        try {
            depts = departmentDao.selectDeptByCdt(new Department());
            if (depts == null) throw new RuntimeException("未查询到任何部门");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return depts;
    }

    @Override
    public Department queryDeptById(Integer deptId) {
        DepartmentDao departmentDao = MyBatisUtils.getMapper(DepartmentDao.class);
        Department dept = null;
        try {
            if (deptId == null) throw new RuntimeException("未收到部门 ID");
            Department department = new Department();
            department.setId(deptId);
            List<Department> departments = departmentDao.selectDeptByCdt(department);
            if (departments == null || departments.size() == 0) throw new RuntimeException("未查询到该部门");
            dept = departments.get(0);
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return dept;
    }

    @Override
    public int deleteDept(Integer deptId) {
        DepartmentDao departmentDao = MyBatisUtils.getMapper(DepartmentDao.class);
        EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);
        int result = 0;
        try {
            if (deptId == null) throw new RuntimeException("未收到要删除的部门对象");
            Department department = new Department();
            department.setId(deptId);

            Employee employee = new Employee();
            employee.setDepartment(department);
            int i = employeeDao.deleteEmpByCdt(employee);
            result = departmentDao.deleteDept(department);
            if (result != 1) throw new RuntimeException("删除部门失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateDept(Department department) {
        DepartmentDao departmentDao = MyBatisUtils.getMapper(DepartmentDao.class);
        int result = 0;
        try {
            if (department == null) throw new RuntimeException("未收到要更新的部门对象");
            result = departmentDao.updateDept(department);
            if (result != 1) throw new RuntimeException("更新部门失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addDept(Department department) {
        DepartmentDao departmentDao = MyBatisUtils.getMapper(DepartmentDao.class);
        int result = 0;
        try {
            if (department == null) throw new RuntimeException("未收到要添加的部门对象");
            result = departmentDao.addDept(department);
            if (result != 1) throw new RuntimeException("添加部门失败");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
