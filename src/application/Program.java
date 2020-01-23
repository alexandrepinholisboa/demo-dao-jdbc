package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao(); 
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		
		for(Seller sellerTemp : sellerList) {
			System.out.println(sellerTemp);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		sellerList = sellerDao.findAll();
		
		for(Seller sellerTemp : sellerList) {
			System.out.println(sellerTemp);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		seller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(seller);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = new Seller(10, "Greg3", "greg3@gmail.com", new Date(), 5500.0, department);
		sellerDao.update(seller);
		
		System.out.println(sellerDao.findById(seller.getId()));
	}

}
