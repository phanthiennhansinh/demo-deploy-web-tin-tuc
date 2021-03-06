package com.hocjavaweb.dto;

import java.util.List;

public class UserDTO extends AbstractDTO<UserDTO>{
	
	private String fullName;
	private String userName;
	private String password;
	private int status;
	private List<UserDTO> code;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<UserDTO> getCode() {
		return code;
	}
	public void setCode(List<UserDTO> code) {
		this.code = code;
	}
	
}
