package com.example.reimbursements;


import com.example.reimbursements.controllers.ManagerController;
import com.example.reimbursements.dao.MmReimbursementRepo;
import com.example.reimbursements.dao.MmUserRepository;
import com.example.reimbursements.dto.*;
import com.example.reimbursements.models.MmReimbursement;
import com.example.reimbursements.models.MmRole;
import com.example.reimbursements.models.MmUser;
import com.example.reimbursements.services.EmployeeService;
import com.example.reimbursements.services.ManagerService;
import com.example.reimbursements.services.UserService;
import com.example.reimbursements.utils.JWTUserDetailsService;
import com.example.reimbursements.utils.JWTUtils;
import com.example.reimbursements.utils.JwtRequestFilter;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ManagerController.class)
@AutoConfigureMockMvc(addFilters = false)
class ReimbursementsApplicationTests {

    @MockBean
    private ManagerService managerService;
    @MockBean
    private EmployeeService employeeService;
    @MockBean
    private MmUserRepository userRepository;
    @MockBean
    private MmReimbursementRepo reimbursementRepo;
    @MockBean
    private RestTemplate restTemplate;
    @MockBean
    private AuthenticationEntryPoint authenticationEntryPoint;
    @MockBean
    PasswordEncoder passwordEncoder;
    @MockBean
    private JWTUserDetailsService userDetailsService;
    @MockBean
    private JWTUtils jwtUtils;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturnModel() throws Exception {
//        MmUser user = new MmUser("sergio.franco", "hash", MmRole.ROLE_MANAGER, "something@revature.net");
//
////
//        when(userRepository.save(user)).thenReturn(user);
//        mockMvc.perform(post("/auth/login").contentType("application/json").content("{\"username\": \"sergio.franco\" \"password\": \"hash\"}"))
//                .andExpect(status().isOk());

        //mockMvc.perform(get("/manager/reimbursements")).andExpect(status().isOk());
    }

    @Test
    public void shouldSaveReimbursement(){
        NewReimbursementDTO reimbursement = new NewReimbursementDTO();
        employeeService.saveReimbursementToRepo(reimbursement);
    }

    @Test
    public void setReimStatusTest(){
        MmUser manager = new MmUser("sergio.franco", "hash", MmRole.ROLE_MANAGER, "something@revature.net");
        MmUser employee = new MmUser("aysha.abreu", "hash", MmRole.ROLE_EMPLOYEE, "somethingelse@revature.net");
        userRepository.save(manager);
        userRepository.save(employee);
        MmReimbursement reimbursement = new MmReimbursement(employee, manager, 30, "approved");
        reimbursementRepo.save(reimbursement);
    }

    @Test
    public void shouldGetAllReimbursements(){
        EmployeeService employeeService = new EmployeeService(reimbursementRepo, userRepository);
        employeeService.getAllReimbursements();
    }

    @Test
    public void saveReimbursementToRepoTest(){
        EmployeeService employeeService = new EmployeeService(reimbursementRepo, userRepository);
        NewReimbursementDTO reimbursementDTO = new NewReimbursementDTO("user", "manager", 15);
        reimbursementDTO.setEmployeeEmail("email");
        employeeService.saveReimbursementToRepo(reimbursementDTO);
    }

    @Test
    public void setReimbursementTest(){
        EmployeeService employeeService = new EmployeeService(reimbursementRepo, userRepository);
        MmUser manager = new MmUser("sergio.franco", "hash", MmRole.ROLE_MANAGER, "something@revature.net");
        MmUser employee = new MmUser("aysha.abreu", "hash", MmRole.ROLE_EMPLOYEE, "somethingelse@revature.net");

        userRepository.save(manager);
        userRepository.save(employee);

        MmReimbursement reimbursement = new MmReimbursement(employee, manager, 30, "approved");

        reimbursement.setId(1);

        reimbursementRepo.save(reimbursement);

    }

    @Test
    public void getEmailTest(){
        EmployeeService employeeService = new EmployeeService(reimbursementRepo, userRepository);

    }

    @Test
    public void shouldGetAllReimbursementsManager(){
        ManagerService managerService = new ManagerService(reimbursementRepo, userRepository);
        managerService.getAllReimbursements();
    }

    @Test
    public void mmUserClassTest(){
        MmUser manager = new MmUser("sergio.franco", "hash", MmRole.ROLE_MANAGER, "something@revature.net");
        manager.getRole();
        manager.getUsername();
        manager.getEmail();
        manager.getRole();
        manager.getId();
        manager.setEmail("ser");
        manager.setHash("wrg");
        manager.setUsername("ser");
        manager.setRole(MmRole.ROLE_MANAGER);
        System.out.println(manager);
    }

    @Test
    public void reimbursementTest(){
        MmUser manager = new MmUser("sergio.franco", "hash", MmRole.ROLE_MANAGER, "something@revature.net");
        MmUser employee = new MmUser("aysha.abreu", "hash", MmRole.ROLE_EMPLOYEE, "somethingelse@revature.net");
        MmReimbursement reimbursement = new MmReimbursement(employee, manager, 30, "approved");
        reimbursement.getStatus();
        reimbursement.getManager();
        reimbursement.getEmployee();
        reimbursement.getAmount();
        reimbursement.getId();
        reimbursement.setManager(manager);
        reimbursement.setStatus("set");
        reimbursement.setAmount(15);
        reimbursement.setEmployee(employee);
        reimbursement.setId(5);
        System.out.println(reimbursement);
    }

    @Test
    public void registerRequestTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("ser");
        registerRequest.setPassword("set");
        registerRequest.setUsername("set");
        registerRequest.getPassword();
        registerRequest.getUsername();
        registerRequest.getEmail();
        UserService service = new UserService();
    }

    @Test
    public void emailReimbursementDTOTest(){
        EmailReimbursementDTO reimbursementDTO = new EmailReimbursementDTO("a", "a", "a", "a", 1);
        reimbursementDTO.setStatus("b");
        reimbursementDTO.setAmount(5);
        reimbursementDTO.getAmount();
        reimbursementDTO.getStatus();
        reimbursementDTO.getEmployeee();
        reimbursementDTO.getManagerr();
        System.out.println(reimbursementDTO);
    }

    @Test
    public void reimbursementDTOTest(){
        ReimbursementDTO reimbursementDTO = new ReimbursementDTO("a","a","a","a",1,1);
        reimbursementDTO.setAmount(1);
        reimbursementDTO.setId(1);
        reimbursementDTO.getAmount();
        reimbursementDTO.getEmployee();
        reimbursementDTO.getManager();
        reimbursementDTO.getId();
        reimbursementDTO.getStatus();
        reimbursementDTO.getEmployeeEmail();
        System.out.println(reimbursementDTO);
    }
    @Test
    public void loginRequestTest(){
        LoginRequest t = new LoginRequest();
        t.setPassword("s");
        t.setUsername("s");
        t.getUsername();
        t.getPassword();
        LoginResponse r = new LoginResponse(true, "a", "a");
        r.setError(true);
        r.setMessge("a");
        r.setMessge("a");
        r.getAuthToken();
        r.getMessge();
    }

}
