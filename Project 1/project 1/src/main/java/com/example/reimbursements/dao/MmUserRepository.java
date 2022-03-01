package com.example.reimbursements.dao;

import com.example.reimbursements.models.MmUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MmUserRepository extends JpaRepository<MmUser, Integer> {
    Optional<MmUser> findByUsername(String username);
    MmUser findMmUserByUsername(String username);
}