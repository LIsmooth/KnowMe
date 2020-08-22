package com.leif.knowme.mapper;

import com.leif.knowme.model.UserDo;

public interface UserMapper {

    UserDo getUserByIdAndName(String id, String name);
    int updateUser(UserDo userDo);
    int removeUserById(String user);

    int createUser(UserDo userDo);
    UserDo getUserById(String id);
}
