package com.example.reimbursements.services;

import com.example.reimbursements.dao.MmReimbursementRepo;
import com.example.reimbursements.dao.MmUserRepository;
import com.example.reimbursements.models.MmReimbursement;
import com.example.reimbursements.models.MmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ManagerService {
    private MmReimbursementRepo reimbursementRepo;
    private MmUserRepository userRepository;

    ///@Autowired
    //public EmployeeService(MmReimbursementRepo reimbursementRepo) {
    //    this.reimbursementRepo = reimbursementRepo;
    //}

    @Autowired
    public ManagerService(MmReimbursementRepo reimbursementRepo, MmUserRepository userRepository) {
        this.reimbursementRepo = reimbursementRepo;
        this.userRepository = userRepository;
    }

    public String getAllReimbursements(){
        String result="";
        for(MmReimbursement e : reimbursementRepo.findAll()){
            result += "The reimbursement with the id " + e.getId() + " was requested by employee " + e.getEmployee().getUsername() +
                    " a and it currently " + e.getStatus() +
            ". The request amount is " + e.getAmount() + " and the manager assigned is " + e.getManager().getUsername() +" \n\n";
        }
        return result;

    }
    @Transactional
    public void setReimStatus(Integer id, String status) {
        MmReimbursement reimbursement = reimbursementRepo.getById(id);
        reimbursement.setStatus(status);
    }

    public MmReimbursement getReimbursement(Integer id){
        return reimbursementRepo.getById(id);
    }

    @Transactional
    public void reassignReimbursement(Integer id, String manager){
        MmReimbursement reimbursement = reimbursementRepo.getById(id);
        MmUser user = userRepository.findMmUserByUsername(manager);
        //if(user==null || user.getRole().equals("ROLE_MANAGER")==false)
        reimbursement.setManager(user);
    }

}