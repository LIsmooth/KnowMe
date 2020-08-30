package com.leif.knowme.api.request;

import java.util.Date;

/**
 * @author HelloLeif
 * @date 2020/8/30
 */
public class CreateUserRequest {
    private String name;
    private Date birthday;
    private Integer gender;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
