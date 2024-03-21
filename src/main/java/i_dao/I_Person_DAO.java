package i_dao;

import java.util.List;

import entities.*;

public interface I_Person_DAO {
	public int addPerson(Person p);
	public List<Person> getListPerson();
	public String getListPerson_ToString();
}
