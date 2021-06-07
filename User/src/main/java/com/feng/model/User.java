package com.feng.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class User implements Serializable {
	
    private Integer userid;//用户id

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

    private Date rdate;//创建时间

	private Date modify;//修改时间

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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
		return rdate==null ? null : (Date)rdate.clone();
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate==null ? null:(Date) rdate.clone();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public Date getModify() {
		return modify;
	}

	public void setModify(Date modify) {
		this.modify = modify;
	}

	@Override
	public String toString() {
		return "User{" +
				"userid=" + userid +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", realname='" + realname + '\'' +
				", sno='" + sno + '\'' +
				", clazz='" + clazz + '\'' +
				", rdate=" + rdate +
				", modify=" + modify +
				'}';
	}
}
   