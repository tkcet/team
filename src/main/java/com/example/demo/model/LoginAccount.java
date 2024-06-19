package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
@Data
@Component
@SessionScope
public class LoginAccount {
	private String name;
	private String email;

	public LoginAccount(String name) {
		this.name = name;
	}

	public LoginAccount() {
	}
	
	
}
