package com.leif.knowme.service;

import com.leif.knowme.dto.UserDto;
import com.leif.knowme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public String createUser(UserDto userDto) {
        return userRepo.createUser(userDto);
    }

    public UserDto getUserById(String userId) {
        return userRepo.getUserById(userId);
    }
}
