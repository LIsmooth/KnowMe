package com.leif.knowme.service;

import com.leif.knowme.po.UserPo;
import com.leif.knowme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public String createUser(UserPo userPo) {
        return userRepo.createUser(userPo);
    }

    public UserPo getUserById(String userId) {
        return userRepo.getUserById(userId);
    }
}
