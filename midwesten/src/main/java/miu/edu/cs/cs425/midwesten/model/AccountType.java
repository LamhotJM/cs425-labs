package miu.edu.cs.cs425.midwesten.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "account_types")
public class AccountType {
	
	public AccountType() {
		// TODO Auto-generated constructor stub
	}

	
//	 public Customer getCustomer() {
//		return customer;
//	}

//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountTypeId;
	private String accountTypeName;
	
	//@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  @OneToOne
//  @JoinColumn(name="student_id", nullable = false, unique = true)
  //  private Customer customer;

	public AccountType(String accountTypeName) {
		super();
		this.accountTypeName = accountTypeName;
	}

	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	
}
