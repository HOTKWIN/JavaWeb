package domain;

import java.util.Date;

/**
 * 封装Emp表数据的JavaBean
 *
 * @author kwin
 * @create 2019-11-23 6:00
 */
public class Emp {
    private int employee_id;
    private String last_name;
    private Date hiredate;
    private Double salary;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "employee_id=" + employee_id +
                ", last_name='" + last_name + '\'' +
                ", hiredate=" + hiredate +
                ", salary=" + salary +
                '}';
    }
}
