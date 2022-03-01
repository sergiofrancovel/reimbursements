package com.example.reimbursements.dao;

import com.example.reimbursements.models.MmReimbursement;
import com.example.reimbursements.models.MmUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MmReimbursementRepo extends JpaRepository<MmReimbursement, Integer> {

}