package jpa.entitymodels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Categorizes Course as an entity
@Table(name = "course") //Identifies which table is referenced
public class Course {
	
	@Id //Designates which variable is used as unique ID
	@Column(name = "id") //Designates which column is represented by this variable
	private Integer cId;
	@Column(name = "name")
	private String cName;
	@Column(name = "instructor")
	private String cInstructorName;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	private List<StudentCourse> students = new ArrayList<>();
		
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
	
	
	public Integer getcId() {
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
