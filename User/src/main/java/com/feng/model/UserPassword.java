package com.feng.model;

import java.io.Serializable;
import java.util.Date;

public class UserPassword implements Serializable {
    private Integer id;//主键

    private String password;//用户密码

    private Integer uid;//用户id

    private Date modify;//修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getModify() {
        return modify ==null ? null : (Date) modify.clone();
    }

    public void setModify(Date modify) {
        this.modify = modify == null ? null: (Date) modify.clone();
    }

    @Override
    public String toString() {
        return "UserPassword{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", uid=" + uid +
                ", modify=" + modify +
                '}';
    }
}
