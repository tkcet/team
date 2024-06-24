package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
		if (record.isEmpty()) {
			model.addAttribute("error", "メールアドレスもしくはパスワードが一致しませんでした");
			return "userLogin";
		}
		Account account = record.get();
		if ( account.getDeletionFlag() == 1) {
			model.addAttribute("error", "メールアドレスもしくはパスワードが一致しませんでした");
			return "userLogin";
		}

		loginAccount.setName(account.getName());
		loginAccount.setEmail(account.getEmail());

		return "userHome";
	}

	@GetMapping("/add")
	public String add(
			@RequestParam(name = "gender", defaultValue = "men") String gender,
			Model model) {
		model.addAttribute("gender", gender);

		return "userAddAccount";
	}

	@PostMapping("/add")
	public String add(
			@RequestParam("name") String name,
			@RequestParam(name = "gender", defaultValue = "") String gender,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			@RequestParam("reEmail") String reEmail,
			@RequestParam("password") String password,
			@RequestParam("rePassword") String rePassword,
			Model model) {

		Optional<Account> record = accountRepository.findByEmail(email);

		List<String> errors = new ArrayList<>();

		if (!email.matches(".*" + "@" + ".*") || !record.isEmpty()) {
			model.addAttribute("emailError", "*");
			errors.add("メールアドレスが重複しています");
		}
		if (!email.equals(reEmail)) {
			model.addAttribute("emailError", "*");
			model.addAttribute("reEmailError", "*");
			errors.add("メールアドレスと確認用メールアドレスが一致しません");
		}
		if (!password.equals(rePassword)) {
			model.addAttribute("passwordError", "*");
			model.addAttribute("rePasswordError", "*");
			errors.add("パスワードと確認用パスワードが一致しません");
		}

		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("address", address);
		model.addAttribute("tel", tel);
		model.addAttribute("email", email);
		model.addAttribute("password", password);

		if (errors.size() != 0) {
			model.addAttribute("errors", errors);
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

		return "redirect:/account/login";
	}

	@GetMapping("/passwordUpdate")
	public String modifyPage() {

		return "userPasswordUpdate";
	}

	@PostMapping("/passwordUpdate")
	public String modify(
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("reNewPassword") String reNewPassword,

			Model model) {

		Optional<Account> record = accountRepository.findByEmailAndTel(email, tel);


		if (!newPassword.equals(reNewPassword)) {
			model.addAttribute("passwordError", "*");
			model.addAttribute("rePasswordError", "*");
			model.addAttribute("error","パスワードと確認用パスワードが一致しません");
			return "userPasswordUpdate";
		}
		Account account = record.get();
		if (record.isEmpty()||account.getDeletionFlag() == 1) {
			model.addAttribute("error", "メールアドレスもしくは電話番号が一致しませんでした");
			return "userPasswordUpdate";
		}

		account.setPassword(newPassword);	
		account.setUpdateDate(LocalDate.now());
		account.setVersionNo(account.getVersionNo()+1);

		accountRepository.saveAndFlush(account);

		return "redirect:/account/login";
	}

	@GetMapping("")
	public String sample() {

		return "sample";
	}
	
}
