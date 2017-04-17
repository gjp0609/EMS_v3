package cn.gjp0609.ems.v3.interceptor;

import cn.gjp0609.ems.v3.entity.Manager;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by gjp06 on 17.4.10.
 */
public class MgrLoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("过滤器开始");

        ValueStack vs = actionInvocation.getStack();
        Manager manager = (Manager) vs.findValue("#session.manager");
        if (manager != null) {
            System.out.println("过滤器 invoke");
            actionInvocation.invoke();
            System.out.println("过滤器 invoked");
            return null;
        } else {
            System.out.println("过滤器 return login");
            HttpServletResponse response = ServletActionContext.getResponse();
//            HttpServletRequest request = ServletActionContext.getRequest();
//            String s = response.encodeRedirectURL(request.getContextPath() + "/commons/login.action");
//            response.sendRedirect(s);
//            response.sendRedirect("/emsv3/commons/login.action");
            return "login";
        }
    }
}
