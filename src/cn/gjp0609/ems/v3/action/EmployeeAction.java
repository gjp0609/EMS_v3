package cn.gjp0609.ems.v3.action;

import cn.gjp0609.ems.v3.entity.Department;
import cn.gjp0609.ems.v3.entity.Employee;
import cn.gjp0609.ems.v3.entity.Page;
import cn.gjp0609.ems.v3.service.EmployeeService;
import cn.gjp0609.ems.v3.service.impl.DeptServiceImpl;
import cn.gjp0609.ems.v3.service.impl.EmpServiceImpl;
import cn.gjp0609.ems.v3.utils.MyBatisUtils;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjp06 on 17.4.16.
 */
public class EmployeeAction extends BaseAction {
    private Page page = new Page();
    private Employee employee = new Employee();
    private List<Employee> employees = new ArrayList<>();
    private Integer id = 0;
    private List<Department> depts;
    private List<Integer> choose = new ArrayList<>();

    /**
     * @return <i>success</i> -> empList.jsp
     */
    public String addEmp() throws Exception {
        employee.setDepartment(new DeptServiceImpl().queryDeptById(employee.getDepartment().getId()));
        // 调用 EmpService 将封装好的对象插入数据库
        new EmpServiceImpl().addEmp(employee);
        // 转发至查询用户页面
        return SUCCESS;
    }

    /**
     * @return <i>success</i> -> empList.jsp
     */
    public String deleteEmp() throws Exception {
        // 调用 EmpService 删除指定员工
        EmployeeService es = new EmpServiceImpl();
//        Employee employee = es.queryEmpById(id);
        Employee employee = new Employee();
        employee.setId(id);
        int i = es.deleteEmp(employee);
        // 无论是否成功都转发至查询界面
        return SUCCESS;
    }

    /**
     * @return <i>success</i> -> empList.jsp
     */
    public String updateEmp() throws Exception {
        employee.setDepartment(new DeptServiceImpl().queryDeptById(employee.getDepartment().getId()));
        new EmpServiceImpl().updateEmp(employee);
        return SUCCESS;
    }

    public String queryAllEmp() throws Exception {
        // 创建部门集合，存入所有部门；每个部门中有 employee 集合，存入所有该部门员工
        // 调用 DeptServiceImpl 获得部门集合
        MyBatisUtils.commit();
        employees = new EmpServiceImpl().queryAllEmp(page);
        System.out.println(employees);
        depts = new DeptServiceImpl().queryAllDept();
//        for (Department dept : depts) dept.setEmployees(employees);
        // 跳转到查询所有员工页面
        return SUCCESS;
    }

    public String getEmpInfo() throws Exception {
        employee = new EmpServiceImpl().queryEmpById(id);
        // 将对象保存到 request 作用域中
        ActionContext.getContext().getValueStack().push(employee);
        // 跳转至更新用户页面
        return "update";
    }

    public String deleteEmps() throws Exception {
        // 调用 EmpService 删除指定员工
        EmployeeService es = new EmpServiceImpl();
        es.deleteEmps(choose);
        System.out.println(choose);
        // 无论是否成功都转发至查询界面
        return SUCCESS;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Department> getDepts() {
        return depts;
    }

    public void setDepts(List<Department> depts) {
        this.depts = depts;
    }

    public List<Integer> getChoose() {
        return choose;
    }

    public void setChoose(List<Integer> choose) {
        this.choose = choose;
    }

}
