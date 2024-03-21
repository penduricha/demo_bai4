package i_dao;

import java.util.List;

import entities.*;

public interface I_Department_DAO {
	public int addDepartment(Department d);
	public List<Department> getListDepartment();
	public String getListDepartment_ToString();
}
