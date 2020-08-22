package com.leif.knowme.repository;

import com.leif.knowme.mapper.UserMapper;
import com.leif.knowme.model.UserDo;
import com.leif.knowme.po.UserPo;
import com.leif.knowme.util.UUIDUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    UserMapper userMapper;

    public String createUser(UserPo userPo) {
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(userPo, userDo);
        userDo.setUserId(UUIDUtils.generateUUID());
        userMapper.createUser(userDo);
        return userDo.getUserId();
    }

    public UserPo getUserById(String userId) {
        UserDo userDo = userMapper.getUserById(userId);
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDo, userPo);
        return userPo;
    }
}
