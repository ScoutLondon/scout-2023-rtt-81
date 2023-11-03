package jpa.entitymodels;

import java.util.ArrayList;
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
	@Column(name = "password")
	private String sPass;
	
	private List<Course> courses;

	
	public Student() {
		setsEmail("Bueller@gmail.com");
		setsName("Ferris Bueller");
		setsPass("DayOff");
		setCourses(new ArrayList<Course>());
	}
	
	public Student(String email, String name, String password) {
		setsEmail(email);
		setsName(name);
		setsPass(password);
		setCourses(new ArrayList<Course>());
	}
	
	//GSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGGSGSGSGSGSGSGSGSGS
	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	

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