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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

	@NotNull(message = "Username cannot be blank")
	@Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
	private String userName;

	@NotNull(message = "User phone cannot be null")
//	@Size(min = 10, max = 10, message = "Userphone must be 10 characters")
//	@Pattern(regexp = "^\\d{10}$", message = "User phone must be a 10-digit number")
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	@Column(unique = true)
	private long userPhone;
	
	@NotNull(message = "User role cannot be null")
	@Enumerated(EnumType.STRING)
	private UserRoles userRole;

	@Schema(hidden = true)
	@OneToMany(mappedBy = "user")
	private List<Orders> orders;
}
