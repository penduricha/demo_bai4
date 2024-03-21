package entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OnsiteCourse")
public class OnsiteCourse {
	
	@Id
	@OneToOne
	@JoinColumn(name = "courseID")
	private Course course;
	@Column(name = "days", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String days;
	@Column(name = "location", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String location;
	@Column(name = "time", length = 100,nullable = false)
	private LocalDateTime time;
	public OnsiteCourse() {
		// TODO Auto-generated constructor stub
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public OnsiteCourse(String days, String location, LocalDateTime time) {
		super();
		this.days = days;
		this.location = location;
		this.time = time;
	}
	@Override
	public String toString() {
		return "OnsiteCourse [course=" + course + ", days=" + days + ", location=" + location + ", time=" + time + "]";
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
