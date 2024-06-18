package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Integer reservationId;
	@Column(name = "orders_id")
	private Integer ordersId;
	@Column(name = "room_id")
	private Integer roomId;
	private Date date;
	@Column(name = "deletion_flag")
	private Integer deletionFlag;

	public Reservation() {

	}

	public Reservation(Integer reservationId, Integer ordersId, Integer roomId, Date date, Integer deletionFlag) {
		this.reservationId = reservationId;
		this.ordersId = ordersId;
		this.roomId = roomId;
		this.date = date;
		this.deletionFlag = deletionFlag;
	}

}
