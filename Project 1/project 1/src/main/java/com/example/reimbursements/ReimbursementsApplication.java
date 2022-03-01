package com.example.reimbursements;

import com.example.reimbursements.dao.MmReimbursementRepo;
import com.example.reimbursements.dao.MmUserRepository;
import com.example.reimbursements.models.MmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;


@SpringBootApplication
public class ReimbursementsApplication {

    private static final Logger logger =  LoggerFactory.getLogger(ReimbursementsApplication.class);

    public static void main(String[] args) {
        logger.info("Initializing ReimbursementApplication app...");
        SpringApplication.run(ReimbursementsApplication.class, args);
    }



    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
