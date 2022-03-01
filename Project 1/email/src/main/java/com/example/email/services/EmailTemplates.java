package com.example.email.services;

import com.example.email.dto.EmailReimbursementDTO;
import com.example.email.dto.ReimbursementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class EmailTemplates {
    private String newReimEmail;
    private String upstateReimStatus;
    private String updateReimManager;

    public void setNewReimEmail( EmailReimbursementDTO reimbursementDTO){
        this.newReimEmail = "Hi, " + reimbursementDTO.getEmployee() + "\n\n" +
                "A new reimbursement has been created under your name. \n" +
                "Here are the details: \n\n" +
                " - Employee: " + reimbursementDTO.getEmployee()+
                "\n - Manager: " + reimbursementDTO.getManager() +
                "\n - Amount: $" + reimbursementDTO.getAmount() + ".00" +
                "\n - Status: pending";
    }

    public String getNewReimEmail() {
        return newReimEmail;
    }

    public void setUpstateReimStatus( ReimbursementDTO reimStatus) {
        this.upstateReimStatus = "Hi, " + reimStatus.getEmployee() + "\n\n" +
        "Your the status of the reimbursement with the id " + reimStatus.getId() + " and the amount of " +
                reimStatus.getAmount() + " has been updated.\n" + "The  new status is: " + reimStatus.getStatus() +
                "\n If you'd like to discuss your status, refer to your manager " + reimStatus.getManager();
    }

    public String getUpstateReimStatus() {
        return upstateReimStatus;
    }

    public void setUpReimManager(ReimbursementDTO reimbursementDTO){
        this.updateReimManager = "Hi, " + reimbursementDTO.getEmployee() + " \n\n" +
                "Your reimbursement with the id " + reimbursementDTO.getId() +
                " and amount " + reimbursementDTO.getAmount() + " has been reassigned to " +
                " a new manager. \n" + "Your new reimbursement manager assigned is now " + reimbursementDTO.getManager() +
                ".\n Thank you.";
    }

    public String getUpdateReimManager() {
        return updateReimManager;
    }
}
