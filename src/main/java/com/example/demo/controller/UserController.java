package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Order;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.RoomRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	//	@Autowired
	//	Account account;

	@Autowired
	HttpSession session;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	RoomRepository roomRepository;

	@GetMapping("/home")
	public String home() {
		return "userHome";
	}

	@GetMapping("/reserve")
	public String reserve(Model model) {
		List<Order> order = orderRepository.findByRoomNo(201);
		LocalDate now = LocalDate.now();
		Integer year = now.getYear();
		Integer month = now.getMonthValue();
		LocalDate date = LocalDate.of(year, month, 1);
		int maxDay = date.lengthOfMonth();
		List<Integer> roomList = roomRepository.findRoom();

		model.addAttribute("roomList", roomList);
		model.addAttribute("lastMonth", month - 1 < 1 ? 12 : month - 1);
		model.addAttribute("month", month);
		model.addAttribute("nextMonth", month + 1 > 12 ? 1 : month + 1);
		model.addAttribute("maxDay", maxDay);

		return "userReserve";
	}

	@PostMapping("/reserve")
	public String reserve(Model model,
			@RequestParam(name = "ordersId", defaultValue = "") Integer ordersId,
			@RequestParam(name = "accountId", defaultValue = "") Integer accountId,
			@RequestParam(name = "roomNo", defaultValue = "0") Integer roomNo,
			@RequestParam(name = "numberPeople", defaultValue = "0") Integer numberPeople,
			@RequestParam(name = "checkIn", defaultValue = "") LocalDate checkIn,
			@RequestParam(name = "checkOut", defaultValue = "") LocalDate checkOut,
			@RequestParam(name = "totalPrice", defaultValue = "0") Integer totalPrice) {
		//Optional<Account> account1 = accountRepository.findByEmail(account.getEmail());
		if (numberPeople == 0 || checkIn == null || checkOut == null) {
			List<Order> order = orderRepository.findByRoomNo(201);
			LocalDate now = LocalDate.now();
			Integer year = now.getYear();
			Integer month = now.getMonthValue();
			LocalDate date = LocalDate.of(year, month, 1);
			int maxDay = date.lengthOfMonth();
			List<Integer> roomList = roomRepository.findRoom();

			model.addAttribute("roomList", roomList);
			model.addAttribute("lastMonth", month - 1 < 1 ? 12 : month - 1);
			model.addAttribute("month", month);
			model.addAttribute("nextMonth", month + 1 > 12 ? 1 : month + 1);
			model.addAttribute("maxDay", maxDay);
			model.addAttribute("error", "入力に不備があります");

			return "userReserve";
		}
		Order order = new Order(ordersId, accountId, roomNo, numberPeople, checkIn, checkOut, totalPrice);

		model.addAttribute("order", order);

		return "userReserveConfirm";
	}

	@PostMapping("/reserve/confirm")
	public String reserveConfirm(Model model,
			@RequestParam(name = "ordersId", defaultValue = "") Integer ordersId,
			@RequestParam(name = "accountId", defaultValue = "1") Integer accountId,
			@RequestParam(name = "roomNo", defaultValue = "") Integer roomNo,
			@RequestParam(name = "numberPeople", defaultValue = "0") Integer numberPeople,
			@RequestParam(name = "checkIn", defaultValue = "") LocalDate checkIn,
			@RequestParam(name = "checkOut", defaultValue = "") LocalDate checkOut,
			@RequestParam(name = "totalPrice", defaultValue = "0") Integer totalPrice) {
		Order order = new Order(ordersId, accountId, roomNo, numberPeople, checkIn, checkOut, totalPrice, 0);
		Order order1 = orderRepository.saveAndFlush(order);

		model.addAttribute("message", "予約を承りました");

		return "end";
	}

	@GetMapping("/archive")
	public String archive(Model model) {
		List<Order> list = orderRepository.findByAccountId(1);

		model.addAttribute("list", list);

		return "userArchive";
	}

	@GetMapping("/update/{ordersId}")
	public String update(Model model,
			@PathVariable("ordersId") Integer ordersId) {
		Order order = null;
		Optional<Order> record = orderRepository.findByOrdersId(ordersId);

		if (record.isEmpty() == false) {
			order = record.get();
		} else {
			return "userArchive";
		}
		model.addAttribute("order", order);

		return "userUpdate";
	}

	@PostMapping("/update")
	public String update(Model model,
			@RequestParam(name = "ordersId", defaultValue = "") Integer ordersId,
			@RequestParam(name = "accountId", defaultValue = "") Integer accountId,
			@RequestParam(name = "roomNo", defaultValue = "") Integer roomNo,
			@RequestParam(name = "numberPeople", defaultValue = "") Integer numberPeople,
			@RequestParam(name = "checkIn", defaultValue = "") LocalDate checkIn,
			@RequestParam(name = "checkOut", defaultValue = "") LocalDate checkOut,
			@RequestParam(name = "totalPrice", defaultValue = "") Integer totalPrice) {
		Order order = new Order(ordersId, accountId, roomNo, numberPeople, checkIn, checkOut, totalPrice, 0);
		Order order1 = orderRepository.saveAndFlush(order);

		model.addAttribute("message", "予約を変更しました");

		return "end";
	}

	@PostMapping("/delete/{ordersId}")
	public String delete(Model model,
			@PathVariable("ordersId") Integer ordersId) {
		Order order = null;
		Optional<Order> record = orderRepository.findByOrdersId(ordersId);

		if (record.isEmpty() == false) {
			order = record.get();
		} else {
			return "userArchive";
		}
		Order order1 = new Order(order.getOrdersId(), order.getAccountId(), order.getRoomNo(),
				order.getNumberPeople(), order.getCheckIn(), order.getCheckOut(), order.getTotalPrice(), 1);
		Order order2 = orderRepository.saveAndFlush(order1);
		
		model.addAttribute("message", "予約をキャンセルしました");

		return "end";
	}

	@GetMapping("/end")
	public String end(Model model) {
		return "end";
	}
}
