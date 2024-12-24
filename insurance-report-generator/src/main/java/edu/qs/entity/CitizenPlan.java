package edu.qs.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "citizen_plan_info")
public class CitizenPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benefitAmt;
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminationReason;
	
	
	public CitizenPlan(String citizenName, String gender, String planName, String planStatus, LocalDate planStartDate,
			LocalDate planEndDate, Double benefitAmt, String denialReason, LocalDate terminatedDate,
			String terminationReason) {
		super();
		this.citizenName = citizenName;
		this.gender = gender;
		this.planName = planName;
		this.planStatus = planStatus;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.benefitAmt = benefitAmt;
		this.denialReason = denialReason;
		this.terminatedDate = terminatedDate;
		this.terminationReason = terminationReason;
	}
	
	
	
	
	
	
	
}
