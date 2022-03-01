package com.example.email;

import com.example.email.services.EmailServiceIntImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailApplication {

    @Autowired
    private EmailServiceIntImpl service;

    /**
     * g35qreqgerg
     * @param args qerhgqetg
     */
    private static final Logger logger =  LoggerFactory.getLogger(EmailApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

//    @Bean
//    public JavaMailSender getJavaMailSenderInstance() {
//        JavaMailSenderImpl javaMailSenderObject = new JavaMailSenderImpl();
//        javaMailSenderObject.setHost("smtp.gmail.com");
//        javaMailSenderObject.setPort(587);
//
//        javaMailSenderObject.setUsername("this.is.my.gmail@gmail.com");
//        javaMailSenderObject.setPassword("password123");
//
//        Properties props = javaMailSenderObject.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//
//        return javaMailSenderObject;
//    }

//    @Bean
//    public CommandLineRunner runner(){
//        return (args -> {
//            JavaMailSender javaMailSender = new JavaMailSenderImpl();
//            EmailServiceIntImpl emailService = new EmailServiceIntImpl(javaMailSender);
//            emailService.sendSimpleMessageForOrder("sergiofrancov10@hotmail.com", "totto", "tototo");
//        });
//    }


    /**
     * this is the actual code to send an email
     */
//    @EventListener(ApplicationReadyEvent.class)
//    public void triggerMail(){
//        service.sendSimpleMessageForOrder("reimbursementspring@gmail.com", "sgr3g", "wrgfwqrg");
//    }


}
