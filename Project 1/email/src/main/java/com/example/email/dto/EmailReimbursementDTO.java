package com.example.email.dto;



public class EmailReimbursementDTO {
    private String employee;
    private String employeeEmail;
    private String manager;
    private String status;
    private int amount;

    public EmailReimbursementDTO(String employee, String employeeEmail, String manager, String status, int amount) {
        this.employee = employee;
        this.employeeEmail = employeeEmail;
        this.manager = manager;
        this.status = status;
        this.amount = amount;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmailReimbursementDTO{" +
                "employee='" + employee + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", manager='" + manager + '\'' +
                ", amount=" + amount +
                '}';
    }
}
