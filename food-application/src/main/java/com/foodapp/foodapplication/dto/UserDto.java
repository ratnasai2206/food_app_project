package com.foodapp.foodapplication.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	
	@NotNull(message = "Username cannot be blank")
	@Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
	public String userName;
	
	
	@NotNull(message = "User phone cannot be null")
	@Pattern(regexp = "^\\d{10}$", message = "User phone must be a 10-digit number")
	public long userPhone;
}
