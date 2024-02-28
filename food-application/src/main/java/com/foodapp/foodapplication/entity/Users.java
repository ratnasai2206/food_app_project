package com.foodapp.foodapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "user_id")
	@SequenceGenerator(name = "user_id",initialValue = 1,allocationSize = 1,sequenceName = "user_sequence")
	private int userId;
	private String userName;
	private long userPhone;
	private String userRole;
}
