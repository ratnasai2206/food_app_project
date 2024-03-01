package com.foodapp.foodapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "review_id")
	@SequenceGenerator(name = "review_id", initialValue = 100, allocationSize = 1, sequenceName = "review_sequence")
	private int reviewId;
	private String reviewComment;
	private double reviewRatings;
	
	@JsonIgnore
	@OneToOne(mappedBy = "review",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private Orders order;

}
