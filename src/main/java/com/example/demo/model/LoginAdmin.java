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
public LoginAdmin(Integer accountId, String password) {
	this.accountId = accountId;
	this.password = password;
}
public LoginAdmin() {
}


}
