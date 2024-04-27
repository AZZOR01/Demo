package com.cpt202.demo.entity;

public class Employee {
    private Integer employeeID;//员工ID
    private Integer employeeAccount;//员工账号
    private String employeeName;//员工姓名
    private String employeePassword;//员工密码
    private String employeeGender;//员工性别
    private Integer employeeAge;//员工年龄
    private String entryTime;//入职时间
    private String staff;//职务
    private String employeeMessage;//备注信息

    public Employee() {
    }

    public Employee(Integer employeeID,Integer employeeAccount, String employeeName, String employeeGender, Integer employeeAge, String entryTime, String staff, String employeeMessage) {
        this.employeeID =employeeID;
        this.employeeAccount = employeeAccount;
        this.employeeName = employeeName;
        this.employeeGender = employeeGender;
        this.employeeAge = employeeAge;
        this.entryTime = entryTime;
        this.staff = staff;
        this.employeeMessage = employeeMessage;
    }

    public Integer getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(Integer employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getEmployeeMessage() {
        return employeeMessage;
    }

    public void setEmployeeMessage(String employeeMessage) {
        this.employeeMessage = employeeMessage;
    }

    public Integer getEmpl0yeeID() {
        return employeeID;
    }

    public void setEmplyeeID(Integer empl0yeeID) {
        this.employeeID = empl0yeeID;
    }


}
