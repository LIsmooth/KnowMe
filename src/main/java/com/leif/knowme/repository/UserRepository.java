package com.leif.knowme.repository;

import com.leif.knowme.dao.UserMapper;
import com.leif.knowme.entity.User;
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
        User user = new User();
        BeanUtils.copyProperties(userPo, user);
        user.setUserId(UUIDUtils.generateUUID());
        userMapper.insertSelective(user);
        return user.getUserId();
    }

    public UserPo getUserById(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(user, userPo);
        return userPo;
    }
}
