package cn.gjp0609.ems.v3.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gjp06 on 17.4.14.
 */
public class Department implements Serializable {
    private Integer id;
    private String name;
    private List<Employee> employees;

    public Department() {
    }

    public Department(Integer id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "\tid=" + id +
                ",\tname='" + name + '\'' +
                ",\temployees=" + employees +
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
