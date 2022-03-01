package com.example.reimbursements.dto;


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

    public EmailReimbursementDTO(String employee, String employeeEmail, String manager, int amount) {
        this.employee = employee;
        this.employeeEmail = employeeEmail;
        this.manager = manager;
        this.amount = amount;
    }

    public EmailReimbursementDTO() {
    }

    public String getEmployeee() {
        return employee;
    }

    public String getManagerr() {
        return manager;
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
