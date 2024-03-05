package com.foodapp.foodapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "item_id")
	@SequenceGenerator(name = "item_id", initialValue = 300, allocationSize = 1, sequenceName = "item_sequence")
	private int itemID;
	@Column(unique = true)
	@NotBlank(message = "Name is required")
	private String itemName;
	@NotNull(message = "Price is required")
	@DecimalMin(value = "0.01", message = "Price must be greater than zero")
	private double itemPrice;
	@NotBlank(message = "Type is required")
	private String itemType;
	@NotNull(message = "Availability status is required")
	private boolean isAvailable;
	@NotNull(message = "Quantity is required")
	@PositiveOrZero(message = "Quantity must be a positive integer or zero")
	private int availableQuantity;
	
}
