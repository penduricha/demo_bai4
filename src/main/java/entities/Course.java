package entities;

import java.util.*;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

	@Id
	@Column(name = "courseID", length = 100, nullable = false)
	private int courseID;
	@Column(name = "credits", length = 100, nullable = false)
	private int credits;
	@Column(name = "title", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String title;
	//Nối 1-1 OnlineCourse
	@OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
	private OnlineCourse onlineCourse;
	@OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
	private OnsiteCourse onsiteCourse;
	@ManyToOne
	@JoinColumn(name = "departmentID")
	private Department department;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<StudentGrade> listStudentGrade=new ArrayList<>();
	
	public Department getDepartment() {
		return department;
	}


	public List<StudentGrade> getListStudentGrade() {
		return listStudentGrade;
	}


	public void setListStudentGrade(List<StudentGrade> listStudentGrade) {
		this.listStudentGrade = listStudentGrade;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public OnsiteCourse getOnsiteCourse() {
		return onsiteCourse;
	}


	public void setOnsiteCourse(OnsiteCourse onsiteCourse) {
		this.onsiteCourse = onsiteCourse;
	}


	public int getCourseID() {
		return courseID;
	}


	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}


	public int getCredits() {
		return credits;
	}


	public void setCredits(int credits) {
		this.credits = credits;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public OnlineCourse getOnlineCourse() {
		return onlineCourse;
	}


	public void setOnlineCourse(OnlineCourse onlineCourse) {
		this.onlineCourse = onlineCourse;
	}


	public Course() {
		// TODO Auto-generated constructor stub
	}


	public Course(int courseID, int credits, String title) {
		super();
		this.courseID = courseID;
		this.credits = credits;
		this.title = title;
	}


	@Override
	public int hashCode() {
		return Objects.hash(courseID);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return courseID == other.courseID;
	}


	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", credits=" + credits + ", title=" + title + "]";
	}
	
}
