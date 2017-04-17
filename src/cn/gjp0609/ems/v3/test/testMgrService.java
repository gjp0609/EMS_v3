package cn.gjp0609.ems.v3.test;

import cn.gjp0609.ems.v3.entity.Manager;
import cn.gjp0609.ems.v3.service.impl.MgrServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * Created by gjp06 on 17.4.16.
 */
public class testMgrService {
    @Test
    void login() {
        Manager manager = new Manager("me", "123", null);
        Manager manager1 = new MgrServiceImpl().login(manager);
        System.out.println(manager + "\n" + manager1);
    }

    @Test
    void register() {
        Manager manager = new Manager("me", "123", null);
        Manager manager1 = new MgrServiceImpl().register(manager);
        System.out.println(manager + "\n" + manager1);
    }
}
