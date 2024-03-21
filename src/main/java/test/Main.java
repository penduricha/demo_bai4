package test;

import java.time.LocalDateTime;

import dao.Course_DAO;
import dao.Department_DAO;
import dao.Person_DAO;
import entities.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course_DAO course_DAO=new Course_DAO();
		Department_DAO department_DAO=new Department_DAO();
		Person_DAO person_DAO=new Person_DAO();
		//khai báo entities;
		Course course1=new Course(1, 30, "English");
		Course course2=new Course(2, 30, "Math");
		OnlineCourse onlineCourse1=new OnlineCourse("www.123.com");
		OnsiteCourse onsiteCourse1=new OnsiteCourse("Mon", "HCM", LocalDateTime.of(2022, 3, 20, 10, 30, 0));
		Department department1=new Department(1, 1, 1, LocalDateTime.of(2022, 3, 20, 10, 30, 0));
		StudentGrade studentGrade1= new StudentGrade(1, 6);
		StudentGrade studentGrade2= new StudentGrade(2, 7);
		Person person1= new Person(1, "A", "Van",LocalDateTime.of(2022, 3, 20, 10, 30, 0), LocalDateTime.of(2022, 3, 20, 10, 30, 0));
		//set
		course1.setOnlineCourse(onlineCourse1);
		onlineCourse1.setCourse(course1);
		//set
		onsiteCourse1.setCourse(course1);
		course1.setOnsiteCourse(onsiteCourse1);
		//set
		department1.getListCourse().add(course1);
		department1.getListCourse().add(course2);
		course1.setDepartment(department1);
		course2.setDepartment(department1);
		//set
		course1.getListStudentGrade().add(studentGrade1);
		course1.getListStudentGrade().add(studentGrade2);
		studentGrade1.setCourse(course1);
		studentGrade2.setCourse(course1);
		//set
		person1.getListStudentGrade().add(studentGrade1);
		person1.getListStudentGrade().add(studentGrade2);
		studentGrade1.setPerson(person1);
		studentGrade2.setPerson(person1);
		
		if(department_DAO.addDepartment(department1)==1)
		{
			System.out.println("Tạo Department thành công.");
		}
		/*
		if(person_DAO.addPerson(person1)==1)
		{
			System.out.println("Tạo Person thành công.");
		}*/
		
		System.out.println("List Course");
		System.out.println(course_DAO.getListCourse_ToString());
		
	}

}
