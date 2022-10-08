package com.citizen_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "citizenName")
	private String citizenName;
	@Column(name = "vaccinationCenterId")
	private int vaccinationCenterId;
	@Column(name ="adhaarNumber", unique = true)
	private long adhaarNumber;
	@Column(name = "mobile")
	private long mobileNumber;

}
