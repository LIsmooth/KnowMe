package com.leif.knowme.mapper;

import com.leif.knowme.model.UserDo;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    UserDo getUserById(String id);
    UserDo getUserByIdAndName(String id, String name);
    int updateUser(UserDo userDo);
    boolean saveUser(UserDo userDo);
    int removeUserById(String user);

    @Select("select * from t_user where user_id=#{userId}")
    UserDo getUserById2(String id);


}
