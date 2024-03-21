package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
@Entity
@Table(name = "Department")
public class Department {
	@Id
	@Column(name = "departmentID", length = 100, nullable = false)
	private int departmentID;
	@Column(name = "administrator", length = 100, nullable = false)
	private int administrator;
	@Column(name = "budget", length = 100, nullable = false)
	private double budget;
	@Column(name = "startDate", length = 100, nullable = false)
	private LocalDateTime startDate;
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Course> listCourse=new ArrayList<>();
	
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public int getAdministrator() {
		return administrator;
	}

	public void setAdministrator(int administrator) {
		this.administrator = administrator;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public List<Course> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}

	public Department(int departmentID, int administrator, double budget, LocalDateTime startDate) {
		super();
		this.departmentID = departmentID;
		this.administrator = administrator;
		this.budget = budget;
		this.startDate = startDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return departmentID == other.departmentID;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", administrator=" + administrator + ", budget=" + budget
				+ ", startDate=" + startDate + "]";
	}
	
}
