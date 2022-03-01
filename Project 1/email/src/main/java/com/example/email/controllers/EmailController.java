package com.example.email.controllers;

import com.example.email.EmailApplication;
import com.example.email.dto.EmailReimbursementDTO;
import com.example.email.dto.ReimbursementDTO;
import com.example.email.services.EmailTemplates;
import com.example.email.services.EmailServiceIntImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailServiceIntImpl service;

    private static final Logger logger =  LoggerFactory.getLogger(EmailApplication.class);

    /**
     * This is a  methods that takes a reimbursment DTO and sends an email with the given details
     * */
    @PostMapping("newreim")
    public ResponseEntity newReimEmail(@RequestBody EmailReimbursementDTO reimbursementDTO){
        logger.info("new reimbursement email is being sent");
        EmailTemplates emailTemplates = new EmailTemplates();
        emailTemplates.setNewReimEmail(reimbursementDTO);
        service.sendSimpleMessageForOrder(reimbursementDTO.getEmployeeEmail(), emailTemplates.getNewReimEmail(),
                "Your new reimbursement has been created");
        System.out.println(reimbursementDTO);
        return ResponseEntity.noContent().build();
    }

    /**
     * This is a  methods that takes a reimbursment DTO and sends an email with the given details
     * */
    @PostMapping("update")
    public ResponseEntity updateStatus(@RequestBody ReimbursementDTO reimbursementDTO){
        logger.info("Sending an email updating the status of given reimbursement...");
        System.out.println(reimbursementDTO);
        EmailTemplates emailTemplates = new EmailTemplates();
        emailTemplates.setUpstateReimStatus(reimbursementDTO);
        service.sendSimpleMessageForOrder(reimbursementDTO.getEmployeeEmail(), emailTemplates.getUpstateReimStatus(),
                "Your reimbursement status was changed");
        return ResponseEntity.accepted().build();
    }

    @PostMapping("reassign")
    public ResponseEntity reassignManager(@RequestBody ReimbursementDTO reimbursementDTO){
        EmailTemplates emailTemplates = new EmailTemplates();
        emailTemplates.setUpReimManager(reimbursementDTO);
        service.sendSimpleMessageForOrder(reimbursementDTO.getEmployeeEmail(), emailTemplates.getUpdateReimManager(),
                "Your reimbursement manager has been changed");
        return ResponseEntity.accepted().build();
    }
}
