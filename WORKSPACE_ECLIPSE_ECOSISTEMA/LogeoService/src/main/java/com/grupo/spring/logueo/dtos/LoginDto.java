package com.grupo.spring.logueo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class LoginDto {
	private Integer id;

	private String nick;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String pass;

	public LoginDto() {

	}

	public LoginDto(Integer id, String nick, String pass) {
		super();
		this.id = id;
		this.nick = nick;
		this.pass = pass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
