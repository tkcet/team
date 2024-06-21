package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.LoginAccount;

@Aspect
@Component
public class CheckLoginAspect {

	@Autowired
	LoginAccount loginAccount;

	@Around( "execution(* com.example.demo.controller.UserController.*(..))"
			)
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {

		if (loginAccount == null || loginAccount.getName() == null
				|| loginAccount.getName().length() == 0) {
			return "redirect:/account/login";
		}
		// Controller内のメソッドの実行
		return jp.proceed();
	}
}
