package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@Component
@SessionScope
public class LoginAdmin {
	private Integer accountId;
	private String password;
	private String name;

	public LoginAdmin(Integer accountId, String password, String name) {
		this.name = name;
		this.accountId = accountId;
		this.password = password;
	}

	public LoginAdmin() {
	}

}
