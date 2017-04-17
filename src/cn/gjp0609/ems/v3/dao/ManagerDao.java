package cn.gjp0609.ems.v3.dao;

import cn.gjp0609.ems.v3.entity.Manager;

/**
 * Created by gjp06 on 17.4.16.
 */
public interface ManagerDao {
    /**
     * 根据用户名查询管理员
     *
     * @param manager 包含查询条件的管理员对象
     * @return 查询得到的管理员对象
     */
    public Manager selectManager(Manager manager);

    /**
     * 插入新管理员
     *
     * @param manager 新管理员对象
     * @return 受影响行数
     */
    public int addManager(Manager manager);
}
