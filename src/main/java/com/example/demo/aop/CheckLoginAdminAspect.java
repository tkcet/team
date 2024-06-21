package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.LoginAdmin;

@Aspect
@Component
public class CheckLoginAdminAspect {

	@Autowired
	LoginAdmin loginAdmin;

	@Around("execution(* com.example.demo.controller.AdminController.home(..))"
			)
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {

		if (loginAdmin == null || loginAdmin.getPassword() == null
				|| loginAdmin.getPassword().length() == 0) {
			return "redirect:/admin/login";
		}
		// Controller内のメソッドの実行
		return jp.proceed();
	}
}
