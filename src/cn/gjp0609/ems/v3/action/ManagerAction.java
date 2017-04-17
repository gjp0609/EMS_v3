package cn.gjp0609.ems.v3.action;

import cn.gjp0609.ems.v3.entity.Manager;
import cn.gjp0609.ems.v3.service.impl.MgrServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;

/**
 * Created by gjp06 on 17.4.16.
 */
public class ManagerAction extends BaseAction {

    // 验证码
    private String vcode;
    // 管理员对象
    private Manager manager;
    // 员工对象，在增加及更新用户时使用

    public String login() throws Exception {

        // 从 session 中取得生成的随机码
        String adminLoginVCode = (String) getSessionValue("adminLoginVCode");
//
        // 判断用户输入的验证码与得到的随机码是否一致
        if (vcode != null && !vcode.isEmpty() && vcode.equalsIgnoreCase(adminLoginVCode)) {
            // 调用管理员登陆业务进行登陆
            manager = new MgrServiceImpl().login(manager);
            // 判断管理员是否登陆成功
            if (manager != null) {
                // 销毁 session 中的验证码
                setSessionValue("", adminLoginVCode);
                // 把成功登陆的管理员对象存入 session 作用域
                setSessionValue("manager", manager);
                // 新建 cookie 对象
                Cookie ck1 = new Cookie("username", manager.getName());
                // 设置 cookie 存活时间，保证登录后 7 天内记住管理员登录名，一天内记住密码
                ck1.setMaxAge(3600 * 24 * 7);
                // 设置 cookie 路径，让 login.jsp 可以取到此 cookie
                ck1.setPath("/emsv3");
                // 将 cookie 添加到浏览器
                ServletActionContext.getResponse().addCookie(ck1);
                // 登陆成功则转发至查询用户页面（empList.jsp）
                System.err.println("success@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                return SUCCESS;
            }
        }
        // 登陆不成功则跳转至登陆页面
        return LOGIN;
    }

    /**
     * @return <i>login</i> 登录页面（login.jsp）<br />
     * <i>none</i> 注册页面（register.jsp）
     */

    public String register() throws Exception {
        // 从 session 中取出生成的随机码
        String adminSignUpVCode = (String) getSessionValue("adminSignUpVCode");
        // 判断用户输入的验证码与得到的随机码是否一致
        if (vcode != null && !vcode.isEmpty() && vcode.equalsIgnoreCase(adminSignUpVCode)) {
            // 调用 AdminService 插入管理员用户
            Manager result = new MgrServiceImpl().register(manager);
            // 判断是否注册成功
            if (result != null) {
                // 转发至登陆页面
                return LOGIN;
            }
        }
        // 注册失败、验证码不匹配，跳转至注册页面
        return NONE;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
