package com.smgk.springcloud.entities;

import java.util.HashMap;
import java.util.Map;

/*
 * 	通用的返回类
 * 用这个类来存储json返回的数据 
 */
public class Msg {
	
	private int code;//返回的状态码
	private String msg;//封装 返回时错误的信息
	private Map<String,Object>extend=new HashMap<String, Object>();//封装 用户要返回给浏览器的数据 
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
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	//这里有两个可能 ，一个成功一个失败
	public static Msg success(){
		Msg result=new Msg();
		result.setCode(100);
		result.setMsg("处理成功");
		return result;
	}
	public static Msg fail(){
		Msg result=new Msg();
		result.setCode(200);
		result.setMsg("处理失败");
		return result;
	}
	
	public Msg add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	@Override
	public String toString() {
		return "Msg [code=" + code + ", msg=" + msg + ", extend=" + extend + "]";
	}
	
	
}
