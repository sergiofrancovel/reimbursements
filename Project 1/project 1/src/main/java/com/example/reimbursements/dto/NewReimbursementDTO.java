package com.example.reimbursements.dto;

import com.example.reimbursements.dao.MmReimbursementRepo;
import com.example.reimbursements.dao.MmUserRepository;
import com.example.reimbursements.models.MmUser;

public class NewReimbursementDTO {
    //private MmUser employee;
    //private MmUser manager;
    private String employee;
    private String employeeEmail;
    private String manager;

    private int amount;

    //private MmUserRepository userRepository;

    public NewReimbursementDTO() {
    }

    public NewReimbursementDTO(String employee, String manager, int amount) {
        this.employee = employee;
        this.manager = manager;
        this.amount = amount;
    }

    //    public NewReimbursementDTO(String employee, String manager, int amount) {
//        this.employeee = userRepository.findMmUserByUsername(employee);
//        System.out.println(this.employee);
//        this.manager = userRepository.findMmUserByUsername(manager);
//        this.amount = amount;
//    }


    public String getEmployee() {
        return employee;
    }

    public String getManager() {
        return manager;
    }

//    public MmUser getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(MmUser employee) {
//        this.employee = employee;
//    }
//
//    public MmUser getManager() {
//        return manager;
//    }
//
//    public void setManager(MmUser manager) {
//        this.manager = manager;
//    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Override
    public String toString() {
        return "NewReimbursementDTO{" +
                "employee='" + employee + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", manager='" + manager + '\'' +
                ", amount=" + amount +
                '}';
    }
}
