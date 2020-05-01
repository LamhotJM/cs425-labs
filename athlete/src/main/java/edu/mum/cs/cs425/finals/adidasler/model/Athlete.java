package edu.mum.cs.cs425.finals.adidasler.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "athletes")
public class Athlete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long athleteId;

	@NotNull(message = "* SSN is required")
	@Column(name = "ssn", nullable = false, unique = true)
	@Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "* SSN must be a valid SSN formated as 123-45-67.")
	private String ssn;

	@NotBlank(message = "* Full name is a required field")
	private String fullName;

	// @Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "*
	// Contact number must be a valid phone number formated as (123) 456-7890.")
	private String phoneNumber;

	@NotNull(message = "* Date of birth is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	@NotNull(message = "* Date of registration is required.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfRegistration;

	@NotNull(message = "* Number of medals won is required.")
	private int totalNumberOfMedalsWon;

	@NotNull(message = "* Monthly salary is required")
	@Digits(integer = 9, fraction = 2, message = "* Monthly salary must be a numeric/monetary amount in decimal (money) format as 'xxx.xx'")
	@NumberFormat(pattern = "$#,###.##")
	private Double monthlySalary;

	// @Pattern(regexp =
	// "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",
	// message = "Enter valid email")
	private String emailAddress;

	public int getTotalNumberOfMedalsWon() {
		return totalNumberOfMedalsWon;
	}

	public void setTotalNumberOfMedalsWon(int totalNumberOfMedalsWon) {
		this.totalNumberOfMedalsWon = totalNumberOfMedalsWon;
	}

	public Athlete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Athlete(Long athleteId,
			@NotNull(message = "* SSN is required") @Pattern(regexp = "\\d{3}-\\d{2}-\\d{4}", message = "* SSN must be a valid SSN formated as 123-45-6789.") 
	String ssn,
			@NotBlank(message = "* Full name is a required field") 
	String fullName,
			@Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Contact number must be a valid phone number formated as (123) 456-7890.") 
	String phoneNumber,
			@NotEmpty(message = "* Date of birth is required.") 
	LocalDate dateOfBirth,
			@NotEmpty(message = "* Date of registration is required.") 
	LocalDate dateOfRegistration,
			@NotEmpty(message = "* Number of medals won is required.") 
	int totalNumberOfMedalsWon,
			@NotNull(message = "* Monthly salary is required") @Digits(integer = 9, fraction = 2, message = "* Monthly salary must be a numeric/monetary amount in decimal (money) format as 'xxx.xx'")
	Double monthlySalary,
			@NotBlank(message = "* Email is a required field") @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "Enter valid email") 
	String emailAddress) {
		this.athleteId = athleteId;
		this.ssn = ssn;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.dateOfRegistration = dateOfRegistration;
		this.totalNumberOfMedalsWon = totalNumberOfMedalsWon;
		this.monthlySalary = monthlySalary;
		this.emailAddress = emailAddress;
	}

	

	

	public Long getAthleteId() {
		return athleteId;
	}

	public void setAthleteId(Long athleteId) {
		this.athleteId = athleteId;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(LocalDate dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public Double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(Double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
