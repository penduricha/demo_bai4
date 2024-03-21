package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.Hibernate;
import entities.Course;

import i_dao.I_Course_DAO;
import jakarta.persistence.TypedQuery;

public class Course_DAO implements I_Course_DAO{
	List<Course> listCourse = new ArrayList<>();
	Hibernate hibernate=new Hibernate("CenterStudy");
	public Course_DAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addCourse(Course c) {
		try {
			hibernate.getTransaction().begin();
			// Kiểm tra xem khóa chính đã tồn tại hay chưa
			if (hibernate.getEntityManager().find(Course.class, Integer.toString(c.getCourseID())) != null) {
				// Nếu ID đã tồn tại, không thêm vào cơ sở dữ liệu
				System.out.println("CourseID đã tồn tại trong cơ sở dữ liệu.");
				return 0;
				// return false;
			}
			// Nếu khóa chính chưa tồn tại, thực hiện thêm vào cơ sở dữ liệu
			hibernate.getEntityManager().persist(c);
			hibernate.getTransaction().commit();
			System.out.println("Thêm dữ liệu Course thành công!");
			return 1;
		} catch (Exception e) {
			if (hibernate.getTransaction() != null && hibernate.getTransaction().isActive()) {
				hibernate.getTransaction().rollback();
				return -1;
				// return false;
			}
			e.printStackTrace();
			System.out.println(e);
			return -2;
			//herbinate.closeTransaction();
		}
	}

	@Override
	public List<Course> getListCourse() {
		try {
			TypedQuery<Course> query = hibernate.getEntityManager().createQuery("SELECT c FROM Course c", Course.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			//herbinate.closeTransaction();
			return null;
		}
	}

	@Override
	public String getListCourse_ToString() {
		String s="";
		for(Course c: getListCourse())
		{
			s+=c.toString()+"\n";
		}
		return s;
	}

}
