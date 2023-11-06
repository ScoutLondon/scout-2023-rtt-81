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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity //Categorizes Student class as an entity
@Table(name="student") //Identifies which table is referenced
public class Student {
	
	@Id //Designates which variable is used as unique ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //Designates which column is represented by this variable
	private Integer id;
	@Column(name = "email") 
	private String sEmail;
	@Column(name = "name")
	private String sName;
	@Column(name = "password")
	private String sPass;
	
	
	  @OneToMany(mappedBy = "student", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	private List<StudentCourse> courses = new ArrayList();

	
	public Student() {
		setsEmail("Bueller@gmail.com");
		setsName("Ferris Bueller");
		setsPass("DayOff");
		setCourses(new ArrayList<StudentCourse>());
	}
	
	public Student(String email, String name, String password) {
		setsEmail(email);
		setsName(name);
		setsPass(password);
		setCourses(new ArrayList<StudentCourse>());
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

	public List<StudentCourse> getCourses() {
		return courses;
	}

	public void setCourses(List<StudentCourse> courses) {
		this.courses = courses;
	}
	
	

}
