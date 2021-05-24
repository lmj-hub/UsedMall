package com.shop.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
public class User implements Serializable {
    /**
     * 主键用户名
     */
    private String name;

    /**
     *用户密码
     */
    private String password;

    /**
     * 用户的住址
     */
    private String address;

    /**
     * 用户的电话号码
     */
    private String phone;

    /**
     * 账号注册时间
     */
    private Date rdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public User(String name, String password, String address, String phone, Date rdate) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.rdate = rdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", rdate=" + rdate +
                '}';
    }

    public User(){
    }
}
