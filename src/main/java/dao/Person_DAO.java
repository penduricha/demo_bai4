package dao;

import java.util.ArrayList;
import java.util.List;

import database.Hibernate;

import entities.Person;
import i_dao.I_Person_DAO;

public class Person_DAO implements I_Person_DAO{

	List<Person> listPerson = new ArrayList<>();
	Hibernate hibernate=new Hibernate("CenterStudy");
	public Person_DAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addPerson(Person p) {
		try {
			hibernate.getTransaction().begin();
			// Kiểm tra xem khóa chính đã tồn tại hay chưa
			if (hibernate.getEntityManager().find(Person.class, Integer.toString(p.getPersonID()))!= null) {
				// Nếu ID đã tồn tại, không thêm vào cơ sở dữ liệu
				System.out.println("PersonID đã tồn tại trong cơ sở dữ liệu.");
				return 0;
				// return false;
			}
			// Nếu khóa chính chưa tồn tại, thực hiện thêm vào cơ sở dữ liệu
			hibernate.getEntityManager().persist(p);
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
	public List<Person> getListPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getListPerson_ToString() {
		// TODO Auto-generated method stub
		return null;
	}

}
