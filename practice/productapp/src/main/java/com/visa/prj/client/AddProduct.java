package com.visa.prj.client;

import com.visa.prf.dao.PersistenceException;
import com.visa.prf.dao.ProductDao;
import com.visa.prf.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;

public class AddProduct {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			Product p = new Product(0, "Logitech Mouse", "computer", 400.00, 500);
			int id = productDao.addProduct(p);
			System.out.println("Product added with id " + id);
		} catch (PersistenceException e) {
			e.printStackTrace(); // Development stage.
//			System.out.println(e.getMessage()); // Production stage.
		}
	}
}
