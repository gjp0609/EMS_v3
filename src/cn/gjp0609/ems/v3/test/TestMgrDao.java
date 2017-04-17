package cn.gjp0609.ems.v3.test;

import cn.gjp0609.ems.v3.dao.ManagerDao;
import cn.gjp0609.ems.v3.entity.Manager;
import cn.gjp0609.ems.v3.utils.MyBatisUtils;
import cn.gjp0609.ems.v3.utils.SecurityUtils;
import org.junit.jupiter.api.Test;

/**
 * Created by gjp06 on 17.4.16.
 */
public class TestMgrDao {
    @Test
    void testAdd() {
        Manager me = new Manager("me", "123", null);
        Manager manager = new Manager();
        String randomCode = SecurityUtils.getRandomCode(10);
        String md5 = SecurityUtils.getMD5(me.getPassword() + randomCode);
        manager.setName(me.getName());
        manager.setPassword(md5);
        manager.setSalt(randomCode);
        ManagerDao dao = MyBatisUtils.getMapper(ManagerDao.class);
        int i = dao.addManager(manager);
        System.out.println(i);
        MyBatisUtils.commit();
    }
}
