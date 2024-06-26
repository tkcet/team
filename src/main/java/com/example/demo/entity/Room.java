package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_no")
	private Integer roomNo;
	private Integer price;
	@Column(name = "deletion_flag")
	private Integer deletionFlag;

	public Room() {

	}

	public Room(Integer roomNo, Integer price, Integer deletionFlag) {
		this.roomNo = roomNo;
		this.price = price;
		this.deletionFlag = deletionFlag;
	}
}
