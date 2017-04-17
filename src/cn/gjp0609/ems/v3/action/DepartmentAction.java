package cn.gjp0609.ems.v3.action;

import cn.gjp0609.ems.v3.entity.Department;
import cn.gjp0609.ems.v3.service.impl.DeptServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gjp06 on 17.4.16.
 */
public class DepartmentAction extends BaseAction {

    private Integer deptId;
    private String deptName;
    private List<Department> depts;

    public String getDeptInfo() throws Exception {
        Department dept = new DeptServiceImpl().queryDeptById(deptId);
        if (dept == null) {
            // 部门不存在则跳转至主查询界面
            return SUCCESS;
        } else {
            // 部门存在，将查得的部门对象存入 ROOT 区
            ActionContext.getContext().getValueStack().push(dept);
            // 转发至查询部门信息界面
            return "dept";
        }
    }

    public String updateDept() throws Exception {
        System.out.println(deptId);
        Department department = new DeptServiceImpl().queryDeptById(deptId);
        ActionContext.getContext().getValueStack().push(department);
        return SUCCESS;
    }

    public String toUpdateDept() throws Exception {
        Department department = new Department(deptId, deptName, null);
        System.out.println(department);
        new DeptServiceImpl().updateDept(department);
        return SUCCESS;
    }

    public String deleteDept() throws Exception {
        System.out.println(deptId);
        new DeptServiceImpl().deleteDept(deptId);
        return SUCCESS;
    }

    public String addDept() throws Exception {
        Department department = new Department(deptId, deptName, null);
        new DeptServiceImpl().addDept(department);
        return SUCCESS;
    }

    public String getAllDepts() throws Exception {
        System.err.println("call this action");
        ValueStack vs = ActionContext.getContext().getValueStack();
        Map<Integer, String> ds = new HashMap<>();
        List<Department> departments = new DeptServiceImpl().queryAllDept();
        if (depts == null || depts.size() < 1) {
            System.out.println("depts None");
        } else {
            for (Department d : depts) {
                ds.put(d.getId(), d.getName());
            }
        }
        vs.setValue("#session.depts", ds);
        return SUCCESS;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public List<Department> getDepts() {
        return depts;
    }

    public void setDepts(List<Department> depts) {
        this.depts = depts;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
