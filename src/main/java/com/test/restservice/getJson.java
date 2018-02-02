package com.test.restservice;

import java.util.List;

public class getJson {

	private String areaCode;
	private String prefix;
	private String lineNum;
	private List<String> phone;
	
	public getJson(){}	
	
	public getJson(String areaCode, String prefix, String lineNum){
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNum = lineNum;
		this.phone = phone;
	}
	
	public List<String> getPhone() {
		return phone;
	}
	
	public String getAreaCode(){
		return this.areaCode;
	}
	
	public void setAreaCode(String areaCode){
		this.areaCode = areaCode;
	}
	
	public String getprefix(){
		return this.prefix;
	}
	
	public void setprefix(String prefix){
		this.prefix = prefix;
	}
	
	public String getLineNum(){
		return this.lineNum;
	}
	public void setlineNum(String lineNum){
		this.lineNum = lineNum;
	}
	
	public String getPhoneNumber(){
		return new StringBuffer("\"(").append(this.areaCode).append(") ")
				.append(this.prefix)
				.append("-")
				.append(this.lineNum + "\"\n").toString();
	}
	
	@Override
	public String toString() {
		return new StringBuffer("[\"(").append(this.phone).append(") ")
									   .append("\"]").toString();
	}
}
