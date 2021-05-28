package org.gdut.idlegoods.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author mj
 *封装用户需求信息
 */
public class Requirement {
	//需求id
	private Integer reId;
	//需求内容
	//Pattern(regexp="",message="")
	@Length(min =1 ,max = 100)
	private String reMsg;
	//上传时间
	private String reDate;
	//用户id
	private Integer userId;
	
	
	public Requirement() {
		
	}
	public Requirement(Integer reId, String reMsg, String reDate, Integer userId) {
		super();
		this.reId = reId;
		this.reMsg = reMsg;
		this.reDate = reDate;
		this.userId = userId;
	}
	public Integer getReId() {
		return reId;
	}
	public void setReId(Integer reId) {
		this.reId = reId;
	}
	public String getReMsg() {
		return reMsg;
	}
	public void setReMsg(String reMsg) {
		this.reMsg = reMsg;
	}
	public String getReDate() {
		return reDate;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Requirement [reId=" + reId + ", reMsg=" + reMsg + ", reDate=" + reDate + ", userId=" + userId + "]";
	}
	
}
	