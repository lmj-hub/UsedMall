package com.feng.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class User implements Serializable {
	
    private Integer id;//用户id

	@Pattern(regexp = "^(.){2,8}$")
    private String username;//用户名

	@Pattern(regexp = "^(.){6,12}$")
    private String password;//密码

    private String address;//宿舍地址

    @Pattern(regexp = "^1\\d{10}$")
    private String phone;//联系电话

	private String realname;//真实姓名

	private String sno;//学号

    private String clazz;//班级

    private String rdate;//创建时间


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", realname='" + realname + '\'' +
				", sno='" + sno + '\'' +
				", clazz='" + clazz + '\'' +
				", rdate=" + rdate +
				'}';
	}
}
   