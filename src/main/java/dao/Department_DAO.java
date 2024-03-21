package dao;

import java.util.ArrayList;
import java.util.List;

import database.Hibernate;
import entities.Course;
import entities.Department;
import i_dao.I_Department_DAO;

public class Department_DAO implements I_Department_DAO{
	List<Department> listDepartment = new ArrayList<>();
	Hibernate hibernate=new Hibernate("CenterStudy");
	public Department_DAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addDepartment(Department d) {
		try {
			hibernate.getTransaction().begin();
			// Kiểm tra xem khóa chính đã tồn tại hay chưa
			if (hibernate.getEntityManager().find(Course.class, Integer.toString(d.getDepartmentID())) != null) {
				// Nếu ID đã tồn tại, không thêm vào cơ sở dữ liệu
				System.out.println("DepartmentID đã tồn tại trong cơ sở dữ liệu.");
				return 0;
				// return false;
			}
			// Nếu khóa chính chưa tồn tại, thực hiện thêm vào cơ sở dữ liệu
			hibernate.getEntityManager().persist(d);
			hibernate.getTransaction().commit();
			System.out.println("Thêm dữ liệu Department thành công!");
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
	public List<Department> getListDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getListDepartment_ToString() {
		// TODO Auto-generated method stub
		return null;
	}

}
