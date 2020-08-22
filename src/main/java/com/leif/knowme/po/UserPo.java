package com.leif.knowme.po;

import java.util.Date;

public class UserPo {
    private String userId;
    private String name;
    private Date birthday;
    private Integer gender;

    public UserPo() {
    }

    public UserPo(String name, Date birthday, Integer gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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
}
