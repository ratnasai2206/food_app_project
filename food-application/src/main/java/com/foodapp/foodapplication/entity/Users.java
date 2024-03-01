package com.foodapp.foodapplication.entity;

import java.util.List;

import com.foodapp.foodapplication.util.UserRoles;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_id")
	@SequenceGenerator(name = "user_id", initialValue = 1, allocationSize = 1, sequenceName = "user_sequence")
	private int userId;
	private String userName;
	
	@Column(unique = true)
	private long userPhone;
	@Enumerated(EnumType.STRING)
	private UserRoles  userRole;

	@Schema(hidden = true)
	@OneToMany(mappedBy = "user")
	private List<Orders> orders;
}
