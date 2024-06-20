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
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Integer accountId;
	private String name;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private String password;
	@Column(name = "create_date")
	private LocalDate createDate;
	private String creater;
	@Column(name = "update_date")
	private LocalDate updateDate;
	private String updater;
	@Column(name = "version_no")
	private Integer versionNo;
	@Column(name = "deletion_flag")
	private Integer deletionFlag;

	public Account() {

	}
	
	

	public Account(String name, String gender, String address, String tel, String email,
			String password, Integer deletionFlag) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.deletionFlag = deletionFlag;
	}
    


	public Account(String name, String gender, String address, String tel, String email,
			String password) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.password = password;
	}



	public Account(Integer accountId, String name, String gender, String address, String tel, String email,
			String password, LocalDate createDate, String creater, LocalDate updateDate, String updater,
			Integer versionNo, Integer deletionFlag) {
		this.accountId = accountId;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.createDate = createDate;
		this.creater = creater;
		this.updateDate = updateDate;
		this.updater = updater;
		this.versionNo = versionNo;
		this.deletionFlag = deletionFlag;
	}
	
	public Account(String tel, String email,String password) {
		this.tel = tel;
		this.email = email;
		this.password = password;
	}



	public Account(Integer accountId, String tel, String email, String password,Integer deletionFlag) {
		super();
		this.accountId = accountId;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.deletionFlag = deletionFlag;
	}
}
