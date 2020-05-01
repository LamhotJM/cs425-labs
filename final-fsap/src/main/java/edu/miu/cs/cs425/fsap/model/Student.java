package edu.miu.cs.cs425.fsap.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
@Table(name = "students")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotNull(message = "* Student Number is required")
    @Column(unique = true, nullable = false)
    private String studentNumber;

    @NotBlank(message = "* Student Name cannot be empty or blank space(s)")
    @Column(nullable = false)
    private String fullName;

    @Digits(integer = 9, fraction = 2, message = "* CPGA must be a numeric format such as 'x,xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    @Column(nullable = true)
    private Double cpga;
    
    @NotBlank(message="* Email is a required field")
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",
			message = "Enter valid email")
	private String emailAddress;
    
    @NotEmpty(message = "* Contact phone number is required.")
	@Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Contact number must be a valid phone number formated as (123) 456-7890.")
	private String PhoneNumber;


    @NotNull(message = "* Date Supplied is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAdmission;

    @ManyToOne
    @JoinColumn(name="faculty_id", nullable = false)
    private Faculty faculty;

    public Student(Long studentId, String studentNumber, String name, Double unitPrice, Integer quantityInStock, LocalDate dateSupplied, Faculty faculty) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.fullName = name;
        this.cpga = unitPrice;
        this.dateOfAdmission = dateSupplied;
        this.faculty = faculty;
    }

    public Student(
			@NotNull(message = "* Student Number is required") String studentNumber,
			@NotBlank(message = "* Student Name cannot be empty or blank space(s)") String fullName,
			@Digits(integer = 9, fraction = 2, message = "* CPGA must be a numeric format such as 'x,xxx.xx'") Double cpga,
			@NotBlank(message = "* Email is a required field") @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "Enter valid email") String emailAddress,
			@NotEmpty(message = "* Contact phone number is required.") @Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Contact number must be a valid phone number formated as (123) 456-7890.") String phoneNumber,
			@NotNull(message = "* Date Supplied is required") LocalDate dateOfAdmission, Faculty faculty) {
		super();
		this.studentNumber = studentNumber;
		this.fullName = fullName;
		this.cpga = cpga;
		this.emailAddress = emailAddress;
		PhoneNumber = phoneNumber;
		this.dateOfAdmission = dateOfAdmission;
		this.faculty = faculty;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getCpga() {
		return cpga;
	}

	public void setCpga(Double cpga) {
		this.cpga = cpga;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Student(String studentNumber, String name, Double unitPrice, Integer quantityInStock, LocalDate dateSupplied, Faculty faculty) {
        this(null, studentNumber, name, unitPrice, quantityInStock, dateSupplied, faculty);
    }

    public Student() {
        this(null, null, null, null, null, null);
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String name) {
        this.fullName = name;
    }

    public Double getUnitPrice() {
        return cpga;
    }

    public void setUnitPrice(Double unitPrice) {
        this.cpga = unitPrice;
    }


    public LocalDate getDateSupplied() {
        return dateOfAdmission;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateOfAdmission = dateSupplied;
    }

    public Faculty getSupplier() {
        return faculty;
    }

    public void setSupplier(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("studentId=" + studentId)
                .add("studentNumber=" + studentNumber)
                .add("name='" + fullName + "'")
                .add("unitPrice=" + cpga)
                .add("dateSupplied=" + dateOfAdmission)
                .add("supplier=" + faculty.getFacultyId() + " - " + faculty.getFacultyNumber() + " - " + faculty.getName())
                .toString();
    }

}
