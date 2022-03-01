package com.example.reimbursements.services;

import com.example.reimbursements.dao.MmUserRepository;
import com.example.reimbursements.dto.RegisterRequest;
//import com.example.reimbursements.models.MmProfile;
import com.example.reimbursements.models.MmRole;
import com.example.reimbursements.models.MmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    MmUserRepository userRepository;

    public MmUser registerUser(RegisterRequest registerRequest) {
        //MmProfile profile = new MmProfile(0, registerRequest.getEmail());

        MmUser user = new MmUser(registerRequest.getUsername(), encoder.encode(registerRequest.getPassword()), MmRole.ROLE_MANAGER, registerRequest.getEmail());

        return userRepository.save(user);

    }
}
