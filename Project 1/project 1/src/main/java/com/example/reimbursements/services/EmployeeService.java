package com.example.reimbursements.services;

import com.example.reimbursements.dao.MmReimbursementRepo;
import com.example.reimbursements.dao.MmUserRepository;
import com.example.reimbursements.dto.NewReimbursementDTO;
import com.example.reimbursements.models.MmReimbursement;
import com.example.reimbursements.models.MmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    private MmReimbursementRepo reimbursementRepo;
    private MmUserRepository userRepository;

    ///@Autowired
    //public EmployeeService(MmReimbursementRepo reimbursementRepo) {
    //    this.reimbursementRepo = reimbursementRepo;
    //}

    @Autowired
    public EmployeeService(MmReimbursementRepo reimbursementRepo, MmUserRepository userRepository) {
        this.reimbursementRepo = reimbursementRepo;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveReimbursementToRepo(NewReimbursementDTO reimbursementDTO){
        //System.out.println(reimbursementDTO.getEmployee());
        //MmReimbursement reimbursement = new MmReimbursement(reimbursementDTO.getEmployee(), reimbursementDTO.getManager(), reimbursementDTO.getAmount(), "pending");
        MmReimbursement reimbursement = new MmReimbursement(userRepository.findMmUserByUsername(reimbursementDTO.getEmployee()),
                userRepository.findMmUserByUsername(reimbursementDTO.getManager()), reimbursementDTO.getAmount(),
                "pending");
        reimbursementRepo.save(reimbursement);
    }

    @Transactional
    public String getReimbursement(Integer id){
        MmReimbursement reimbursement = reimbursementRepo.getById(id);
        return "Your reimbursement of the amount " + reimbursement.getAmount() + " is currently being handled by the user " +
                "with the username " + reimbursement.getManager().getUsername() + " and the status is " +
                "currently: " + reimbursement.getStatus();
    }

    public String getAllReimbursements(){
        String result="";
        for(MmReimbursement e : reimbursementRepo.findAll()){
            result += "Your reimbursement with the id " + e.getId() + " and amount " + e.getAmount() + " is currently " +e.getStatus()+
                    ". The manager assigned is " + e.getManager().getUsername() +" \n\n";
        }
        return result;
    }

    @Transactional
    public String getUserEmail(String username){
        MmUser user = userRepository.findMmUserByUsername(username);
        return user.getEmail();
    }

}
