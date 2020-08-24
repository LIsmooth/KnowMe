package com.leif.knowme.model;

import java.util.Date;

public class UserDo {
    private String userId;
    private String name;
    private Date birthday;
    private Byte gender;
    private String phone;
    private Date created;


    public UserDo(){
        super();
    }
    public UserDo(String userId, String name, Date birthday) {
        this.userId = userId;
        this.name = name;
        this.birthday = birthday;
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

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
