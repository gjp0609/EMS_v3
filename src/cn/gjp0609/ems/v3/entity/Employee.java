package cn.gjp0609.ems.v3.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gjp06 on 17.4.14.
 */
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Double salary;
    private Date birthday;
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String name, String sex, Double salary, Date birthday, Department department) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        this.birthday = birthday;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "\tid=" + id +
                ",\tname='" + name + '\'' +
                ",\tsex='" + sex + '\'' +
                ",\tsalary=" + salary +
                ",\tbirthday=" + birthday +
                ",\tdepartment=" + department +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
