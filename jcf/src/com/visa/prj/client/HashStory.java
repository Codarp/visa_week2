package com.visa.prj.client;

import com.visa.prj.entity.Product;

public class HashStory {
	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1 == s2);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		// One case of collision.
		String s3 = new String("Aa");
		String s4 = new String("BB");
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
		Product p1 = new Product(645, "Hp Laptop", 135000.00, "computer", 600);
		Product p2 = new Product(645, "Hp Laptop", 135000.00, "computer", 600);
		
		
	}
}
