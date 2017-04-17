package cn.gjp0609.ems.v3.dao;

import cn.gjp0609.ems.v3.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * EmployeeDao
 * Created by gjp06 on 17.4.14.
 */

/**
 * 查询员工
 */
public interface EmployeeDao {
    /**
     * 根据指定条件查询员工<br/>
     * 条件封装在员工对象中，没有则为 <b>null</b>
     * <b>多条件为并列关系</b>
     *
     * @param employee 包含查询条件的员工对象
     * @return 包含符合查询条件的员工对象d的集合
     */
    public List<Employee> selectEmpByCdt(@Param("emp") Employee employee,
                                         @Param("firstRow") Integer firstRow,
                                         @Param("lastRow") Integer lastRow);

    /**
     * 根据指定条件删除员工<br/>
     * 指定部门 ID，用于在删除部门前调用，实现级联删除<br/>
     * 指定员工其他属性，根据属性删除员工<br/>
     * <b>多条件为并列关系，不能通过部门名称删除</b>
     *
     * @param employee 要删除的员工对象
     * @return 受影响行数
     */
    public int deleteEmpByCdt(Employee employee);

    /**
     * 更新员工信息
     *
     * @param employee 要更新的员工对象
     * @return 受影响员工个数
     */
    public int updateEmp(Employee employee);

    /**
     * 增加新员工
     *
     * @param employee 要增加的员工对象
     * @return 受影响员工个数
     */
    public int addEmp(Employee employee);

    public int selectTotalRows();

    public int deleteEmpByIds(@Param("ids") List<Integer> ids);
}
