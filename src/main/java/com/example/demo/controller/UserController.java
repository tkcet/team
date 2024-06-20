package com.example.demo.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

import com.example.demo.entity.Account;
import com.example.demo.entity.Order;
import com.example.demo.entity.Room;
import com.example.demo.model.LoginAccount;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.RoomRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	LoginAccount loginAccount;

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
	public String reserve(Model model,
			@RequestParam(name = "month", required = false) Integer month,
			@RequestParam(name = "floor", required = false) Integer floor) {
		List<Order> order = null;
		LocalDate now = LocalDate.now();
		Integer year = now.getYear();
		month = month != null ? month : now.getMonthValue();
		LocalDate date = LocalDate.of(year, month, 1);
		int maxDay = date.lengthOfMonth();

		List<Integer> roomList = roomRepository.findRoom();
		Integer[][] roomEmpty = new Integer[30][31];

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 31; j++) {
				roomEmpty[i][j] = 0;
			}
		}

		for (int i = 0; i < 30; i++) {
			order = orderRepository.findOrders(roomList.get(i));
			for (int j = 0; j < 31; j++) {
				for (Order o : order) {
					// 月を跨がない予約
					if (month == o.getCheckIn().getMonthValue() && month == o.getCheckOut().getMonthValue()) {
						if ((o.getCheckIn().getDayOfMonth() - 1) <= j && j <= (o.getCheckOut().getDayOfMonth() - 1)) {
							roomEmpty[i][j] = 1;
						}
					}
					// 月を跨ぐ予約
					if (month == o.getCheckIn().getMonthValue() && month != o.getCheckOut().getMonthValue()) {
						if ((o.getCheckIn().getDayOfMonth() - 1) <= j && j < 31) {
							roomEmpty[i][j] = 1;
						}
					}
					if (month != o.getCheckIn().getMonthValue() && month == o.getCheckOut().getMonthValue()) {
						if (0 <= j && j <= (o.getCheckOut().getDayOfMonth() - 1)) {
							roomEmpty[i][j] = 1;
						}
					}
				}
			}
		}

		model.addAttribute("roomList", roomList);
		model.addAttribute("lastMonth", month - 1 < 1 ? 12 : month - 1);
		model.addAttribute("month", month);
		model.addAttribute("nextMonth", month + 1 > 12 ? 1 : month + 1);
		model.addAttribute("maxDay", maxDay);
		model.addAttribute("roomEmpty", roomEmpty);
		Integer[] Floor = { 0, 1, 2 };
		if (floor == null) {
			floor = 0;
		}
		model.addAttribute("Floor", Floor[floor] * 10);

		return "userReserve";

	}

	@PostMapping("/reserve")
	public String reserve(Model model,
			@RequestParam(name = "month", required = false) Integer month,
			@RequestParam(name = "floor", required = false) Integer floor,
			@RequestParam(name = "ordersId", defaultValue = "") Integer ordersId,
			@RequestParam(name = "accountId", defaultValue = "") Integer accountId,
			@RequestParam(name = "roomNo", defaultValue = "0") Integer roomNo,
			@RequestParam(name = "numberPeople", defaultValue = "0") Integer numberPeople,
			@RequestParam(name = "checkIn", defaultValue = "") LocalDate checkIn,
			@RequestParam(name = "checkOut", defaultValue = "") LocalDate checkOut,
			@RequestParam(name = "totalPrice", defaultValue = "0") Integer totalPrice) {
		List<Order> order = null;
		LocalDate now = LocalDate.now();
		Integer year = now.getYear();
		month = month != null ? month : now.getMonthValue();
		LocalDate date = LocalDate.of(year, month, 1);
		int maxDay = date.lengthOfMonth();
		List<Integer> roomList = roomRepository.findRoom();
		Integer[][] roomEmpty = new Integer[30][31];

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 31; j++) {
				roomEmpty[i][j] = 0;
			}
		}

		for (int i = 0; i < 30; i++) {
			order = orderRepository.findOrders(roomList.get(i));
			for (int j = 0; j < 31; j++) {
				for (Order o : order) {
					// 月を跨がない予約
					if (month == o.getCheckIn().getMonthValue() && month == o.getCheckOut().getMonthValue()) {
						if ((o.getCheckIn().getDayOfMonth() - 1) <= j
								&& j <= (o.getCheckOut().getDayOfMonth() - 1)) {
							roomEmpty[i][j] = 1;
						}
					}
					// 月を跨ぐ予約
					if (month == o.getCheckIn().getMonthValue() && month != o.getCheckOut().getMonthValue()) {
						if ((o.getCheckIn().getDayOfMonth() - 1) <= j && j < 31) {
							roomEmpty[i][j] = 1;
						}
					}
					if (month != o.getCheckIn().getMonthValue() && month == o.getCheckOut().getMonthValue()) {
						if (0 <= j && j <= (o.getCheckOut().getDayOfMonth() - 1)) {
							roomEmpty[i][j] = 1;
						}
					}
				}
			}
		}

		model.addAttribute("roomList", roomList);
		model.addAttribute("lastMonth", month - 1 < 1 ? 12 : month - 1);
		model.addAttribute("month", month);
		model.addAttribute("nextMonth", month + 1 > 12 ? 1 : month + 1);
		model.addAttribute("maxDay", maxDay);
		model.addAttribute("roomEmpty", roomEmpty);
		Integer[] Floor = { 0, 1, 2 };
		if (floor == null) {
			floor = 0;
		}
		model.addAttribute("Floor", Floor[floor] * 10);

		int count = 0;
		List<String> error = new ArrayList<>();
		if (checkIn == null || checkOut == null) {
			error.add("チェックイン・チェックアウトの日を入力してください");
			count++;
		}

		Integer[] booking = new Integer[31];

		for (int i = 0; i < 31; i++) {
			booking[i] = 0;
		}
		Integer day1 = checkIn.getDayOfMonth() - 1;
		Integer day2 = checkOut.getDayOfMonth() - 1;
		for (int i = day1; i <= day2; i++) {
			booking[i] = 1;
		}
		if (roomNo == 0) {
			for (int i = 0; i < 30; i++) {
				int judge = 0;
				for (int j = 0; j < 31; j++) {
					if (roomEmpty[i][j] == 1 && booking[j] == 1) {
						judge++;
					}
				}
				if (judge == 0) {
					roomNo = roomList.get(i);
					break;
				}
			}
		}

		int bookingRoom = 100;
		for (int i = 0; i < 30; i++) {
			if (roomNo == (int) roomList.get(i)) {
				bookingRoom = i;
			}
		}
		if (bookingRoom != 100) {
			for (int i = 0; i < 31; i++) {
				if (roomEmpty[bookingRoom][i] == 1 && booking[i] == 1) {
					error.add("予約が埋まっています");
					model.addAttribute("error", error);

					return "userReserve";
				}
			}
		}

		if (ChronoUnit.DAYS.between(checkIn, checkOut) == 0) {
			error.add("チェックインとチェックアウトが同じ日です");
			count++;
		}
		if ((int) (ChronoUnit.DAYS.between(checkIn, checkOut)) < 0) {
			error.add("チェックインがチェックアウトより前です");
			count++;
		}
		List<Room> room = roomRepository.findByRoomNo(roomNo);
		if (room.isEmpty()) {
			error.add("他の部屋番号を入力してください");
			count++;
		}
		if (count != 0) {
			model.addAttribute("error", error);

			return "userReserve";
		}

		totalPrice = roomRepository.findPrice(roomNo) * numberPeople
				* (int) (ChronoUnit.DAYS.between(checkIn, checkOut));

		Order order1 = new Order(ordersId, accountId, roomNo, numberPeople, checkIn, checkOut, totalPrice);

		model.addAttribute("order", order1);

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
		Optional<Account> record = accountRepository.findByEmail(loginAccount.getEmail());
		Account account = record.get();
		List<Order> list = orderRepository.findByAccountId(account.getAccountId());

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
		List<Order> orderList = null;
		LocalDate now = LocalDate.now();
		Integer year = now.getYear();
		Integer month = checkIn.getMonthValue();
		LocalDate date = LocalDate.of(year, month, 1);
		int maxDay = date.lengthOfMonth();
		List<Integer> roomList = roomRepository.findRoom();
		Integer[][] roomEmpty = new Integer[30][31];

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 31; j++) {
				roomEmpty[i][j] = 0;
			}
		}

		for (int i = 0; i < 30; i++) {
			orderList = orderRepository.findOrders(roomNo);
			for (int j = 0; j < 31; j++) {
				for (Order o : orderList) {
					// 月を跨がない予約
					if (month == o.getCheckIn().getMonthValue() && month == o.getCheckOut().getMonthValue()) {
						if ((o.getCheckIn().getDayOfMonth() - 1) <= j
								&& j <= (o.getCheckOut().getDayOfMonth() - 1)) {
							roomEmpty[i][j] = 1;
						}
					}
					// 月を跨ぐ予約
					if (month == o.getCheckIn().getMonthValue() && month != o.getCheckOut().getMonthValue()) {
						if ((o.getCheckIn().getDayOfMonth() - 1) <= j && j < 31) {
							roomEmpty[i][j] = 1;
						}
					}
					if (month != o.getCheckIn().getMonthValue() && month == o.getCheckOut().getMonthValue()) {
						if (0 <= j && j <= (o.getCheckOut().getDayOfMonth() - 1)) {
							roomEmpty[i][j] = 1;
						}
					}
				}
			}
		}

		int count = 0;
		List<String> error = new ArrayList<>();
		if (checkIn == null || checkOut == null) {
			error.add("チェックイン・チェックアウトの日を入力してください");
			count++;
		}

		Integer[] booking = new Integer[31];

		for (int i = 0; i < 31; i++) {
			booking[i] = 0;
		}
		Integer day1 = checkIn.getDayOfMonth() - 1;
		Integer day2 = checkOut.getDayOfMonth() - 1;
		for (int i = day1; i <= day2; i++) {
			booking[i] = 1;
		}
		if (roomNo == 0) {
			for (int i = 0; i < 30; i++) {
				int judge = 0;
				for (int j = 0; j < 31; j++) {
					if (roomEmpty[i][j] == 1 && booking[j] == 1) {
						judge++;
					}
				}
				if (judge == 0) {
					roomNo = roomList.get(i);
					break;
				}
			}
		}

		int bookingRoom = 100;
		for (int i = 0; i < 30; i++) {
			if (roomNo == (int) roomList.get(i)) {
				bookingRoom = i;
			}
		}
		if (bookingRoom != 100) {
			for (int i = 0; i < 31; i++) {
				if (roomEmpty[bookingRoom][i] == 1 && booking[i] == 1) {
					error.add("予約が埋まっています");
					model.addAttribute("error", error);

					return "userReserve";
				}
			}
		}
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
