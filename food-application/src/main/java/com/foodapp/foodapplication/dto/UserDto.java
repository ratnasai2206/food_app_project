package com.foodapp.foodapplication.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
//	@Size(min = 10, max = 10, message = "Userphone must be 10 characters")
//	@Pattern(regexp = "^\\d{10}$", message = "User phone must be a 10-digit number")
	public long userPhone;
}
