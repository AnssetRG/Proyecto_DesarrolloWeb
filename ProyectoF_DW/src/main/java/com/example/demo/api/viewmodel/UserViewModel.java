package com.example.demo.api.viewmodel;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class UserViewModel {

	private Long idUser;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Min(5)
	private String password;
	
	@NotNull
	private Boolean vip;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}
	
	
	
}
