package com.foodapp.foodapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
	private String itemName;
	private double itemPrice;
	private String itemType;
	private boolean isAvailable;
	private int availableQuantity;
	
}
