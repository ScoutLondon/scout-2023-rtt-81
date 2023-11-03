package jpa.entitymodels;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//TODO: One to many relationship


@Entity //Categorizes Student class as an entity
@Table(name="student") //Identifies which table is referenced
public class Student {
	
	@Id //Designates which variable is used as unique ID
	@Column(name = "email") //Designates which column is represented by this variable
	private String sEmail;
	@Column(name = "name")
	private String sName;
	@Column(name = "pasword")
	private String sPass;
	
	private List<Course> courses;

}
/*
@Entity
@Table(name="customers")
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Order> orders;
	

	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "contact_firstname")
	private String contactFirstname;
	
	@Column(name = "credit_limit", columnDefinition="Decimal(10,2)")
	private Double creditLimit;
*/