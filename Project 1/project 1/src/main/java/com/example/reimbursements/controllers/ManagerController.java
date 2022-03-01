package com.example.reimbursements.controllers;

import com.example.reimbursements.dto.ReimbursementDTO;
import com.example.reimbursements.models.MmReimbursement;
import com.example.reimbursements.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("manager")
@PreAuthorize("hasRole('ROLE_MANAGER')")
public class ManagerController {

    private ManagerService managerService;
    private RestTemplate restTemplate;

    @Value("${api.config.email-api-url:http://localhost:8081/email}")
    private String url;



    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }


    @GetMapping("reimbursements")
    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> getAllReimbursements(){
        return ResponseEntity.ok(managerService.getAllReimbursements());
    }

    @PutMapping("{id}")
    public ResponseEntity setReimStatus(@RequestBody String status, @PathVariable Integer id){
        managerService.setReimStatus(id, status);

        MmReimbursement reimbursement = managerService.getReimbursement(id);
        ReimbursementDTO emailReimbursementDTO = new ReimbursementDTO(reimbursement.getEmployee().getUsername(),
                reimbursement.getEmployee().getEmail(), reimbursement.getManager().getUsername(), reimbursement.getStatus(),
                reimbursement.getAmount(), reimbursement.getId());

        ResponseEntity resp = restTemplate.postForEntity(url + "/update", emailReimbursementDTO, null);
        if(resp.getStatusCode().is5xxServerError()){
            ResponseEntity.internalServerError().build();
        }
        ResponseEntity.noContent().build();
        return ResponseEntity.ok("The status of the reimbursement has been updated to: " + status);

    }

    @PutMapping("reassign/{id}")
    public ResponseEntity reassignReimbursement(@PathVariable Integer id, @RequestBody String manager){
        managerService.reassignReimbursement(id, manager);

        MmReimbursement reimbursement = managerService.getReimbursement(id);
        ReimbursementDTO reimbursementDTO = new ReimbursementDTO(reimbursement.getEmployee().getUsername(),
                reimbursement.getEmployee().getEmail(), reimbursement.getManager().getUsername(), reimbursement.getStatus(),
                reimbursement.getAmount(), reimbursement.getId());

        ResponseEntity resp = restTemplate.postForEntity(url+"/reassign", reimbursementDTO, null);
        if(resp.getStatusCode().is5xxServerError()){
            ResponseEntity.internalServerError().build();
        }
        ResponseEntity.noContent().build();
        return ResponseEntity.ok("Reimbursement was reassigned to manager " + manager);

    }


}