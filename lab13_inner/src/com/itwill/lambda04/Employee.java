package com.itwill.lambda04;

public class Employee {
    
    //field
    private int empId;
    private String empName;
    private String dept;
    private String empTitile;
    private double salary;
    
    public Employee(int empId, String empName, String dept, String empTitile, double salary) {
       
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
        this.empTitile = empTitile;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmpTitile() {
        return empTitile;
    }

    public void setEmpTitile(String empTitile) {
        this.empTitile = empTitile;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", dept=" + dept + ", empTitile=" + empTitile
                + ", salary=" + salary + "]";
    } 
    
    
}
