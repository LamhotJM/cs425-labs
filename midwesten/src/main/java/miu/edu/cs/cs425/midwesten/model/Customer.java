package miu.edu.cs.cs425.midwesten.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer customerId;
	private String customerNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailAddress;
	private String contactPhoneNumber;
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Account> products = new ArrayList<>();
	
	 @OneToOne
	 @JoinColumn(name="account_type_id", nullable = false, unique = true)
//	    @OneToOne(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 private AccountType account_type;
	
	public Customer(String customerNumber, String firstName, String middleName, String lastName, String emailAddress,
			String contactPhoneNumber, LocalDate dateOfBirth, List<Account> products) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.contactPhoneNumber = contactPhoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.products = products;
	}

	public Integer getCustomerID() {
		return customerId;
	}

	public void setCustomerID(Integer customerID) {
		this.customerId = customerID;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Account> getProducts() {
		return products;
	}

	public void setProducts(List<Account> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerId + ", customerNumber=" + customerNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", contactPhoneNumber=" + contactPhoneNumber + ", dateOfBirth=" + dateOfBirth + ", products="
				+ products + "]";
	}



	
	
	

}
