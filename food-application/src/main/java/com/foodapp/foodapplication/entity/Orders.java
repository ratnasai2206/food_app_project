package com.foodapp.foodapplication.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "orderId_generator")
	@SequenceGenerator(name="orderId_generator",allocationSize = 1,initialValue = 200)
	private int orderId;
	
	@Enumerated(EnumType.STRING)
	private String status;
	private double totalAmount;
	@Enumerated(EnumType.STRING)
	private String paymentMode;
	
	@CreationTimestamp
	private LocalDateTime createdDateAndTime;
	
	@ManyToMany
	private List<Items> items;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Review review;
	
	
	@ManyToOne
	@JoinColumn
	private Users user;
}
