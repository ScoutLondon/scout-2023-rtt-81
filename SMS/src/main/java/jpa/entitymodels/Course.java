package jpa.entitymodels;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//TODO: One to many relationship

@Entity //Categorizes Course as an entity
@Table(name = "course") //Identifies which table is referenced
public class Course {
	
	@Id //Designates which variable is used as unique ID
	@Column(name = "id") //Designates which column is represented by this variable
	private int cId;
	@Column(name = "name")
	private String cName;
	@Column(name = "instructor")
	private String cInstructorName;
	
	
	public Course() {
		setcId(1986);
		setcName("Economics");
		setcInstructorName("Ben Stein");
	}
	
	public Course(int id, String name, String instructor) {
		setcId(id);
		setcName(name);
		setcInstructorName(instructor);
	}
	
	//GSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSGSG
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcInstructorName() {
		return cInstructorName;
	}
	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
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