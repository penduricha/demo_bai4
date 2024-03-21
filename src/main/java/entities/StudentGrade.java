package entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
@Entity
@Table(name = "StudentGrade")
public class StudentGrade {

	@Id
	@Column(name = "enrollmentID", length = 100, nullable = false)
	private int enrollmentID;
	@Column(name = "grade", length = 100, nullable = false)
	private double grade;
	//có khối 1.5 nha cô 
	//Nối
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseID")
	private Course course;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personID")
	private Person person;
	
	public int getEnrollmentID() {
		return enrollmentID;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public void setEnrollmentID(int enrollmentID) {
		this.enrollmentID = enrollmentID;
	}


	public double getGrade() {
		return grade;
	}


	public void setGrade(double grade) {
		this.grade = grade;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public StudentGrade() {
		// TODO Auto-generated constructor stub
	}


	public StudentGrade(int enrollmentID, double grade) {
		super();
		this.enrollmentID = enrollmentID;
		this.grade = grade;
	}

}
