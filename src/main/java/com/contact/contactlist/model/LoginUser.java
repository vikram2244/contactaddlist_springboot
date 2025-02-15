package com.contact.contactlist.model;

public class LoginUser {
	private String email;
	private String password;
	public String getEmailLogin() {
		return email;
	}
	public void setEmailLogin(String emailLogin) {
		this.email = emailLogin;
	}
	public String getPasswordLogin() {
		return password;
	}
	public void setPasswordLogin(String passwordLogin) {
		this.password = passwordLogin;
	}
	@Override
	public String toString() {
		return "LoginUser [email=" + email + ", password=" + password + "]";
	}
	
	
	

}
