package cn.gjp0609.ems.v3.service;

import cn.gjp0609.ems.v3.entity.Employee;
import cn.gjp0609.ems.v3.entity.Page;

import java.util.List;

/**
 * Created by gjp06 on 17.4.16.
 */
public interface EmployeeService {

    public List<Employee> queryAllEmp(Page page);

    public Employee queryEmpById(Integer id);

    public int deleteEmp(Employee employee);

    public int updateEmp(Employee employee);

    public int addEmp(Employee employee);

    public List<Employee> queryEmpByCdt(Employee employee);

    public int deleteEmps(List<Integer> ids);
}
