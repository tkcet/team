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
			model.addAttribute("error", "「IDもしくはパスワードが一致しませんでした");
			return "adminLogin";
		}
		session.setAttribute("accountId", accountId);
		session.setAttribute("password", password);

		model.addAttribute("accountAll", accountAll);
		return "adminHome";
	}

	@GetMapping("/top")
	public String top(
			Model model) {
		Integer accountId = (Integer) session.getAttribute("accountId");
		String password = (String) session.getAttribute("password");
		System.out.println(accountId);
		System.out.println(password);
		return login(accountId, password, model);

	}

	@GetMapping("/update/{acccountId}")
	public String home(
			@RequestParam("accountId") Integer accountId,
			Model model) {
		Account account = accountRepository.findById(accountId).get();
		System.out.println(account);
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
			@RequestParam("updater") String updater,
			Model model) {

		int errorCount = 0;

		Optional<Account> record = accountRepository.findByEmail(email);

		if (!email.matches(".*" + "@" + ".*") || !record.isEmpty()) {
			model.addAttribute("emailError", "*");
			errorCount++;
		}

		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("address", address);
		model.addAttribute("tel", tel);
		model.addAttribute("email", email);

		if (errorCount != 0) {
			model.addAttribute("error", "再入力する必要があります");
			return "adminUpdateExecute";
		}

		Account account = accountRepository.findById(accountId).get();
		System.out.println("aaa");

		String password = account.getPassword();
		LocalDate createDate = account.getCreateDate();
		String creater = account.getCreater();
		//		Integer versionNo1 = account.getVersionNo()+1;
		Integer versionNo = account.getVersionNo() + 1;
		account.setVersionNo(versionNo);
		Integer deletionFlag = account.getDeletionFlag();

		account.setUpdateDate(LocalDate.now());
		LocalDate updateDate = account.getUpdateDate();
		Account newAccount = new Account(accountId, name, gender, address, tel, email, password, createDate, creater,
				updateDate, updater, versionNo, deletionFlag);

		System.out.println("ccc");

		accountRepository.save(newAccount);

		//途中
		model.addAttribute("newAccount", newAccount);

		//return "redirect:/admin/login";
		//		return login(3, "himitu", model);
		return "adminUpdateConfirm";
	}

	@PostMapping("/delete")
	public String delete(
			@RequestParam("accountId") Integer accountId,
			@RequestParam("updater") String updater,
			Model model) {
		Account account = accountRepository.findById(accountId).get();
		account.setDeletionFlag(1);
		account.setUpdater(updater);
		account.setUpdateDate(LocalDate.now());
		accountRepository.save(account);

		//		return "";
		//		return login(3, "himitu", model);
		return "redirect:/admin/top";
	}
}
