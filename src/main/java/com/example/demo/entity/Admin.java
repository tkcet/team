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
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Integer adminId;
	private String name;
	private String password;
	@Column(name = "deletion_flag")
	private Integer deleteionFlag;

	public Admin() {

	}

	public Admin(Integer adminId, String name, String password, Integer deleteionFlag) {
		this.adminId = adminId;
		this.name = name;
		this.password = password;
		this.deleteionFlag = deleteionFlag;
	}

}
