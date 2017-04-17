package cn.gjp0609.ems.v3.dao;

import cn.gjp0609.ems.v3.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gjp06 on 17.4.16.
 */
public interface DepartmentDao {
    /**
     * 根据指定条件查询部门<br/>
     * 指定部门 ID 或名称，查询指定部门<br/>
     * 不指定则查询所有部门<br/>
     * <b>多条件为并列关系</b>
     *
     * @param department 要删除的部门对象
     * @return 存放所有部门对象的集合
     */
    public List<Department> selectDeptByCdt(Department department);

    /**
     * 增加新部门
     *
     * @param department 要增加的部门对象
     * @return 受影响部门个数
     */
    public int addDept(Department department);

    /**
     * 根据指定条件删除部门<br/>
     * 指定部门 ID 或名称，删除指定部门<br/>
     * 不指定则删除所有部门<br/>
     * <b>多条件为并列关系</b>
     *
     * @param department 要删除的部门对象
     * @return 受影响部门个数
     */
    public int deleteDept(Department department);

    /**
     * 更新部门信息
     *
     * @param department 要更新的部门对象
     * @return 受影响部门个数
     */
    public int updateDept(Department department);
}
