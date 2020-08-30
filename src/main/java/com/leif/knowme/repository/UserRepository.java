package com.leif.knowme.repository;

import com.leif.knowme.dao.UserMapper;
import com.leif.knowme.entity.User;
import com.leif.knowme.dto.UserDto;
import com.leif.knowme.util.UUIDUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    UserMapper userMapper;

    public String createUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setUserId(UUIDUtils.generateUUID());
        userMapper.insertSelective(user);
        return user.getUserId();
    }

    public UserDto getUserById(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
