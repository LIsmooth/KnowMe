package com.leif.knowme.controller;

import com.leif.knowme.api.request.CreateUserRequest;
import com.leif.knowme.base.KmRequest;
import com.leif.knowme.dto.UserDto;
import com.leif.knowme.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(headers = "Accept=application/json")
    public String createUser(@RequestBody KmRequest<CreateUserRequest> request) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(request.getData(), userDto);
        return userService.createUser(userDto);
    }
}
