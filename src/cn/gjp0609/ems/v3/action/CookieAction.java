package cn.gjp0609.ems.v3.action;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.interceptor.CookiesAware;

import java.util.Map;


/**
 * Created by gjp06 on 17.4.16.
 */
public class CookieAction implements Action, CookiesAware {
    private String username;
    private String password;

    @Override
    public void setCookiesMap(Map<String, String> map) {
        this.username = map.get("username");
        this.password = map.get("password");
        System.out.println(username + " " + password);
    }

    @Override
    public String execute() throws Exception {
        return "success";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
