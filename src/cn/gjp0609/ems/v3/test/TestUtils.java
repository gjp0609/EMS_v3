package cn.gjp0609.ems.v3.test;

import cn.gjp0609.ems.v3.dao.ManagerDao;
import cn.gjp0609.ems.v3.utils.MyBatisUtils;
import org.junit.jupiter.api.Test;

/**
 * Created by gjp06 on 17.4.16.
 */
public class TestUtils {
    @Test
    void testMapper(){
        ManagerDao mapper = MyBatisUtils.getMapper(ManagerDao.class);
        System.out.println(mapper);
    }
}
