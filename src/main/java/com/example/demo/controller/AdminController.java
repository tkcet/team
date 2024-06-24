package com.example.demo.controller;

import java.time.LocalDate;
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
import com.example.demo.model.LoginAdmin;
import com.example.demo.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	HttpSession session;

	@Autowired
	LoginAdmin loginAdmin;

	@GetMapping({ "/login", "/logout" })
	public String index(
			//			@RequestParam String error,
			Model model) {
		session.invalidate();
		return "adminLogin";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam("accountId") Integer accountId,
			@RequestParam("password") String password,
			Model model) {
		Account account = null;
		List<Account> accountAll = null;
		if (accountId == 1 || accountId == 2 || accountId == 3) {

			account = accountRepository.findById(accountId).get();
			String correctPassword = account.getPassword();
			Integer deletionFlag = account.getDeletionFlag();
			if (correctPassword.equals(password) && deletionFlag == 0) {
				accountAll = accountRepository.findByDeletionFlag(0);
			}

		}

		if (accountAll == null) {
			model.addAttribute("error", "IDもしくはパスワードが一致しませんでした");
			return "adminLogin";
		}
		loginAdmin.setAccountId(accountId);
		loginAdmin.setName(account.getName());
		loginAdmin.setPassword(password);

		model.addAttribute("accountAll", accountAll);
		return "adminHome";
	}

	@GetMapping("/top")
	public String top(
			Model model) {
		Integer accountId = loginAdmin.getAccountId();
		String password = loginAdmin.getPassword();
		return login(accountId, password, model);

	}

	@GetMapping("/update")
	public String modufyPage(
			@RequestParam("accountId") Integer accountId,
			Model model) {
		Account account = accountRepository.findById(accountId).get();
		model.addAttribute("account", account);
		return "adminUpdateExecute";
	}

	@PostMapping("/update")
	public String modify(
			@RequestParam("accountId") Integer accountId,
			@RequestParam("name") String name,
			@RequestParam("gender") String gender,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			Model model) {

		int errorCount = 0;
		Optional<Account> record = accountRepository.findByEmail(email);

		if (!record.isEmpty()) {
			Account account = record.get();
			if (account.getAccountId() != accountId) {
				model.addAttribute("emailError", "メールアドレスが重複しています");
				errorCount++;
			}

		}
		Account account = accountRepository.findById(accountId).get();

		if (errorCount != 0) {

			model.addAttribute("account", account);
			return "adminUpdateExecute";
		}

		account.setName(name);
		account.setGender(gender);
		account.setAddress(address);
		account.setTel(tel);
		account.setEmail(email);
		account.setVersionNo(account.getVersionNo() + 1);
		account.setUpdater(loginAdmin.getName());
		account.setUpdateDate(LocalDate.now());

		accountRepository.save(account);

		model.addAttribute("newAccount", account);

		return "adminUpdateConfirm";
	}

	@PostMapping("/delete")
	public String delete(
			@RequestParam("accountId") Integer accountId,
			Model model) {
		Account account = accountRepository.findById(accountId).get();
		account.setDeletionFlag(1);
		account.setUpdater(loginAdmin.getName());
		account.setUpdateDate(LocalDate.now());
		accountRepository.save(account);

		return "redirect:/admin/top";
	}
}
