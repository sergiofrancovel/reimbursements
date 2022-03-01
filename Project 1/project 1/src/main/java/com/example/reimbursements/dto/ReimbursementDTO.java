package com.example.reimbursements.dto;

public class ReimbursementDTO {
    private String employee;
    private String employeeEmail;
    private String manager;
    private String status;
    private int amount;
    private int id;

    public ReimbursementDTO(String employee, String employeeEmail, String manager, String status, int amount, int id) {
        this.employee = employee;
        this.employeeEmail = employeeEmail;
        this.manager = manager;
        this.status = status;
        this.amount = amount;
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReimbursementDTO{" +
                "employee='" + employee + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", manager='" + manager + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", id=" + id +
                '}';
    }
}
