package com.visa.prj.client;

import java.util.List;

import com.visa.prf.dao.FetchException;
import com.visa.prf.dao.ProductDao;
import com.visa.prf.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;

public class ListProducts {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl(); // use factory to get dao instance.
		
		try {
			List<Product> prds = productDao.getProducts();
			for (Product p : prds) {
				System.out.println(p.getName() + ", " + p.getPrice());
			}
		} catch (FetchException e) {
			e.printStackTrace();
		}
	}
}
