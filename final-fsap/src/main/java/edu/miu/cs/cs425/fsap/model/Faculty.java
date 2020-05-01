package edu.miu.cs.cs425.fsap.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facultyId;

    @NotNull(message = "* Faculty Number is required")
    @Digits(integer = 6, fraction = 0, message = "* Faculty number must be numeric; and a positive, integral value")
    @Column(unique = true, nullable = false)
    private Integer facultyNumber;

    @NotNull(message = "* Faculty Name is required")
    @NotBlank(message = "* Faculty Name cannot be empty or blank space(s)")
    @Column(nullable = false)
    private String fullName;
    
    @NotBlank(message="* Email is a required field")
   	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",
   			message = "Enter valid email")
   	private String emailAddress;
     
    @NotEmpty(message = "* Contact phone number is required.")
 	@Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Contact number must be a valid phone number formated as (123) 456-7890.")
 	private String PhoneNumber;


    private String officeLocation;

    //@OneToMany(mappedBy = "students", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private List<Student> student = new ArrayList<>();

    public Faculty() {
		super();
	
	}

	public Faculty(
			@NotNull(message = "* Faculty Number is required") @Digits(integer = 6, fraction = 0, message = "* Faculty number must be numeric; and a positive, integral value") Integer facultyNumber,
			@NotNull(message = "* Faculty Name is required") @NotBlank(message = "* Faculty Name cannot be empty or blank space(s)") String fullName,
			@NotBlank(message = "* Email is a required field") @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "Enter valid email") String emailAddress,
			@NotEmpty(message = "* Contact phone number is required.") @Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Contact number must be a valid phone number formated as (123) 456-7890.") String phoneNumber,
			String officeLocation) {
		super();
		this.facultyNumber = facultyNumber;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		PhoneNumber = phoneNumber;
		this.officeLocation = officeLocation;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	public Faculty(Integer supplierId, Integer supplierNumber, String name, String contactPhoneNumber, List<Student> students) {
        this.facultyId = supplierId;
        this.facultyNumber = supplierNumber;
        this.fullName = name;
        this.officeLocation = contactPhoneNumber;
       // this.student = students;
    }

    public Faculty(Integer supplierNumber, String name, String contactPhoneNumber, List<Student> students) {
        this(null, supplierNumber, name, contactPhoneNumber, students);
    }

    public Faculty(String string, String string2, String string3, String string4, String string5, String string6) {
        this(null, null, null, null);
    }

  

	public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer supplierId) {
        this.facultyId = supplierId;
    }

    public Integer getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(Integer supplierNumber) {
        this.facultyNumber = supplierNumber;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String name) {
        this.fullName = name;
    }

    public String getContactPhoneNumber() {
        return officeLocation;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.officeLocation = contactPhoneNumber;
    }

//    public List<Student> getProducts() {
//        return student;
//    }
//
//    public void setProducts(List<Student> students) {
//        this.student = students;
//    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Faculty.class.getSimpleName() + "[", "]")
                .add("supplierId=" + facultyId)
                .add("supplierNumber=" + facultyNumber)
                .add("name='" + fullName + "'")
                .add("contactPhoneNumber='" + officeLocation + "'")
               // .add("students=" + student)
                .toString();
    }
}
