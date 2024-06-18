package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orders_id")
	private Integer ordersId;
	@Column(name = "account_id")
	private Integer accountId;
	@Column(name = "room_no")
	private Integer roomNo;
	@Column(name = "number_people")
	private Integer numberPeople;
	@Column(name = "check_in")
	private LocalDate checkIn;
	@Column(name = "check_out")
	private LocalDate checkOut;
	@Column(name = "total_price")
	private Integer totalPrice;
	@Column(name = "deletion_flag")
	private Integer deletionFlag;

	public Order() {

	}

	public Order(Integer ordersId, Integer accountId, Integer roomNo, Integer numberPeople, LocalDate checkIn,
			LocalDate checkOut, Integer totalPrice) {
		this.ordersId = ordersId;
		this.accountId = accountId;
		this.roomNo = roomNo;
		this.numberPeople = numberPeople;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalPrice = totalPrice;
	}

	public Order(Integer ordersId, Integer accountId, Integer roomNo, Integer numberPeople, LocalDate checkIn,
			LocalDate checkOut, Integer totalPrice, Integer deletionFlag) {
		this.ordersId = ordersId;
		this.accountId = accountId;
		this.roomNo = roomNo;
		this.numberPeople = numberPeople;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalPrice = totalPrice;
		this.deletionFlag = deletionFlag;
	}

}
