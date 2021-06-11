package com.js.dto;

public class RegisterDto {
	private String userId;
	private String pwd;
	private String email;
	private String enabled;
	public RegisterDto() {
	//	super();
		// TODO Auto-generated constructor stub
	}
	public RegisterDto(String userId, String pwd, String email, String enabled) {
	//	super();
		this.userId = userId;
		this.pwd = pwd;
		this.email = email;
		this.enabled = enabled;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "RegisterDto [userId=" + userId + ", pwd=" + pwd + ", email=" + email + ", enabled=" + enabled + "]";
	}
	
	
}
