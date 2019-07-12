package com.visa.prj.client;

import com.visa.prj.entity.Product;
import com.visa.prj.util.SQLUtil;

public class AnnotationsClient {
	public static void main(String[] args) {
		Product p = new Product();
		System.out.println(SQLUtil.createStatement(Product.class));
	}
}
