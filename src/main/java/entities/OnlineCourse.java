package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OnlineCourse")
public class OnlineCourse {

	@Id
	@OneToOne
    @JoinColumn(name = "courseID")
	private Course course;
	@Column(name = "url", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String url;
	
	public OnlineCourse() {
		// TODO Auto-generated constructor stub
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public OnlineCourse(String url) {
		super();
		this.url = url;
	}

	@Override
	public String toString() {
		return "OnlineCourse [course=" + course + ", url=" + url + "]";
	}

}
