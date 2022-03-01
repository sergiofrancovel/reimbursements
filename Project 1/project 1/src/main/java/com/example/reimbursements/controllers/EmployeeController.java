package com.example.reimbursements.controllers;

import com.example.reimbursements.ReimbursementsApplication;
import com.example.reimbursements.dto.EmailReimbursementDTO;
import com.example.reimbursements.dto.NewReimbursementDTO;
import com.example.reimbursements.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("reimbursement")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class EmployeeController {

    private EmployeeService employeeService;
    private RestTemplate restTemplate;

    @Value("${api.config.email-api-url:http://localhost:8081/email}")
    private String url;

    private static final Logger logger =  LoggerFactory.getLogger(ReimbursementsApplication.class);

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Post request that takes a reimbursementDTO as a parameter and creates a new reimbursement with the given details.
     * It then sends a post request to the email api to send and email to the user about the actions taken.
     * @param reimbursementDTO Object used to create the reimbursement
     * @return Returns the status of the reimbursement.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNewReimbursement(@RequestBody NewReimbursementDTO reimbursementDTO){
        EmailReimbursementDTO emailReimbursementDTO = new EmailReimbursementDTO(reimbursementDTO.getEmployee()
        ,employeeService.getUserEmail(reimbursementDTO.getEmployee()), reimbursementDTO.getManager(), reimbursementDTO.getAmount());
        employeeService.saveReimbursementToRepo(reimbursementDTO);

        reimbursementDTO.setEmployeeEmail(employeeService.getUserEmail(reimbursementDTO.getEmployee()));

        System.out.println(emailReimbursementDTO);

        System.out.println(reimbursementDTO);

        ResponseEntity resp = restTemplate.postForEntity(url+"/newreim", reimbursementDTO, null);
        if(resp.getStatusCode().is5xxServerError()){
            return ResponseEntity.internalServerError().build();
        }
        ResponseEntity.noContent().build();

        return ResponseEntity.ok("New reimbursement has been created. The current status is: pending");
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getCurrentReimbursement(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.getReimbursement(id));
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllReimbursements(){
        return ResponseEntity.ok(employeeService.getAllReimbursements());
    }
}
