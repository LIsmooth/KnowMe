package com.leif.knowme.controller;

import com.leif.knowme.base.KmRequest;
import com.leif.knowme.po.UserPo;
import com.leif.knowme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(headers = "Accept=application/json")
    public String createUser(@RequestBody KmRequest<UserPo> request) {
        return userService.createUser(request.getData());
    }
}
