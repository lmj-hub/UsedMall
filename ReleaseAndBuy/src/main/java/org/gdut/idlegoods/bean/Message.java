package org.gdut.idlegoods.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *封装返回给前端的数据，使返回数据格式一致
 */
public class Message {
	//状态码，反映处理结果
	//200表示成功，-1表示失败
	 private int code;
	 //返回信息
	 private String msg;
	 

	 
	 private Map<String,Object>  map = new HashMap<String,Object>();
	 
	 
	 //返回成功信息
	 public static Message success() {
		 Message message = new Message();
		 message.setCode(200);
		 message.setMsg("Processing succeeded");
		 return message;
	 }
	 //返回失败信息
	 public static Message fail() {
		 Message message = new Message();
		 message.setCode(-1);
		 message.setMsg("Processing failed!");
		 return message;
	 }
	 
	 //添加返回数据
	 public Message add(String key,Object value) {
		 this.getMap().put(key, value);
		 return this;
	 }
	 public Message() {
	 }
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}
	
	
	 
}
