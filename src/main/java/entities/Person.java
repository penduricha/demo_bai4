package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	@Column(name = "personID", length = 100, nullable = false)
	private int personID;
	@Column(name = "firstName", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String firstName;
	@Column(name = "lastName", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String lastName;
	@Column(name = "enrollmentDate", length = 100, nullable = false)
	private LocalDateTime enrollmentDate;
	@Column(name = "hireDate", length = 100, nullable = false)
	private LocalDateTime hireDate;
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<StudentGrade> listStudentGrade=new ArrayList<>();

	public int getPersonID() {
		return personID;
	}


	public void setPersonID(int personID) {
		this.personID = personID;
	}


	public List<StudentGrade> getListStudentGrade() {
		return listStudentGrade;
	}


	public void setListStudentGrade(List<StudentGrade> listStudentGrade) {
		this.listStudentGrade = listStudentGrade;
	}


	public Person() {
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public LocalDateTime getEnrollmentDate() {
		return enrollmentDate;
	}


	public void setEnrollmentDate(LocalDateTime enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}


	public LocalDateTime getHireDate() {
		return hireDate;
	}


	public void setHireDate(LocalDateTime hireDate) {
		this.hireDate = hireDate;
	}


	public Person(int personID, String firstName, String lastName, LocalDateTime enrollmentDate,
			LocalDateTime hireDate) {
		super();
		this.personID = personID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enrollmentDate = enrollmentDate;
		this.hireDate = hireDate;
	}
	
}
