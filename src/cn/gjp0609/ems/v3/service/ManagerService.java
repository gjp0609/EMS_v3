package cn.gjp0609.ems.v3.service;

import cn.gjp0609.ems.v3.entity.Manager;

/**
 * Created by gjp06 on 17.4.16.
 */
public interface ManagerService {

    public Manager login(Manager manager);

    public Manager register(Manager manager);
}

