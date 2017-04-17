package cn.gjp0609.ems.v3.service.impl;

import cn.gjp0609.ems.v3.dao.ManagerDao;
import cn.gjp0609.ems.v3.entity.Manager;
import cn.gjp0609.ems.v3.service.ManagerService;
import cn.gjp0609.ems.v3.utils.MyBatisUtils;
import cn.gjp0609.ems.v3.utils.SecurityUtils;

/**
 * Created by gjp06 on 17.4.16.
 */
public class MgrServiceImpl implements ManagerService {
//    private ManagerDao managerDao = MyBatisUtils.getMapper(ManagerDao.class);

    @Override
    public Manager login(Manager manager) {
        ManagerDao mgrDao = MyBatisUtils.getMapper(ManagerDao.class);
        try {
            if (manager == null) throw new RuntimeException("未接收到管理员对象");
            if (manager.getName() == null || manager.getPassword() == null) throw new RuntimeException("收到的管理员对象不完整");
            Manager selMgr = mgrDao.selectManager(manager);
            if (selMgr == null) throw new RuntimeException("查询得到的管理员对象为空");
            String salt = selMgr.getSalt();
            String pwd = manager.getPassword();
            String password = SecurityUtils.getMD5(pwd + salt);
            if (selMgr.getName().equals(manager.getName()))
                if (selMgr.getPassword().equals(password))
                    return selMgr;
                else throw new RuntimeException("登陆密码不正确");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Manager register(Manager manager) {
        ManagerDao mgrDao = MyBatisUtils.getMapper(ManagerDao.class);
        try {
            if (manager == null) throw new RuntimeException("接收到的管理员对象为空");
            if (manager.getName() == null || manager.getPassword() == null) throw new RuntimeException("收到的管理员对象不完整");
            Manager newMgr = new Manager();
            String randomCode = SecurityUtils.getRandomCode(10);
            String md5 = SecurityUtils.getMD5(manager.getPassword() + randomCode);
            newMgr.setName(manager.getName());
            newMgr.setPassword(md5);
            newMgr.setSalt(randomCode);
            int i = mgrDao.addManager(newMgr);
            if (i != 1) throw new RuntimeException("未成功插入");
            MyBatisUtils.commit();
        } catch (Exception e) {
            MyBatisUtils.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
