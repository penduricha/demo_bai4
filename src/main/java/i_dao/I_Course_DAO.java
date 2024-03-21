package i_dao;

import java.util.List;

import entities.Course;

public interface I_Course_DAO {
	public int addCourse(Course c);
	public List<Course> getListCourse();
	public String getListCourse_ToString();
}
