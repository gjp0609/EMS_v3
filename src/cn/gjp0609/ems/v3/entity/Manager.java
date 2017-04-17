package cn.gjp0609.ems.v3.entity;

import java.io.Serializable;

/**
 * Created by gjp06 on 17.4.14.
 */
public class Manager implements Serializable {
    private String name;
    private String password;
    private String salt;

    public Manager() {
    }

    public Manager(String name, String password, String salt) {
        this.name = name;
        this.password = password;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
