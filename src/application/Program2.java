package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao(); 
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> departmentList = departmentDao.findAll();
		
		for(Department departmentTemp : departmentList) {
			System.out.println(departmentTemp);
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		department = new Department(7, "Food");
		departmentDao.insert(department);
		
		System.out.println(department);
		
		System.out.println("\n=== TEST 4: department update ===");
		department = new Department(department.getId(), "NewDepartment");
		departmentDao.update(department);
		
		System.out.println(departmentDao.findById(department.getId()));
		
		System.out.println("\n=== TEST 5: department delete ===");
		departmentDao.deleteById(department.getId());
		
		System.out.println(departmentDao.findById(department.getId()));
		
	}

}
