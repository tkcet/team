package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Account;
import com.example.demo.model.LoginAccount;
import com.example.demo.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	HttpSession session;

	@Autowired
	LoginAccount loginAccount;

	@GetMapping({ "/login", "/logout" })
	public String index(
			//			@RequestParam String error,
			Model model) {
		session.invalidate();
		return "userLogin";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		Optional<Account> record = accountRepository.findByEmailAndPassword(email, password);
		System.out.println(record);
		if (record.isEmpty()) {
			model.addAttribute("error", "メールアドレスもしくはパスワードが一致しませんでした");
			return "userLogin";
		}
		Account account = record.get();
		if (account.getDeletionFlag() == 1) {
			return "userLogin";
		}
		loginAccount.setName(account.getName());

		return "userHome";
	}

	@GetMapping("/add")
	public String add(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "gender", defaultValue = "") String gender,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "email", defaultValue = "") String email,

			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("address", address);
		model.addAttribute("tel", tel);
		model.addAttribute("email", email);

		return "userAddAccount";
	}

	@PostMapping("/add")
	public String add(
			@RequestParam("name") String name,
			@RequestParam(name="gender",defaultValue="") String gender,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		System.out.println("account");
		int errorCount = 0;
			
			Optional<Account> record = accountRepository.findByEmail(email);
			
			if (!email.matches(".*" +"@" + ".*")||!record.isEmpty()) {
				model.addAttribute("emailError", "*");
				errorCount ++;	
			}
			
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("address", address);
		model.addAttribute("tel", tel);
		model.addAttribute("email", email);
		model.addAttribute("password", password);

		if(errorCount != 0) {
				model.addAttribute("error", "再入力する必要があります");
				return "userAddAccount";
			}
		return "userAddAccountConfirm";
	}

	@PostMapping("/add/confirm")
	public String addConfirm(
			@RequestParam("name") String name,
			@RequestParam("gender") String gender,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {

		Account account = new Account(name, gender, address, tel, email, password);
		account.setDeletionFlag(0);
		account.setVersionNo(1);
		account.setCreateDate(LocalDate.now());

		accountRepository.save(account);
		System.out.println(password);

		return "redirect:/account/login";
	}
}
