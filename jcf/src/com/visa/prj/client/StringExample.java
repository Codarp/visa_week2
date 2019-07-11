package com.visa.prj.client;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import com.visa.prj.entity.Product;

public class StringExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer", 100));
		products.add(new Product(224, "iPhone", 98000.00, "mobile", 500));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer", 300));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv", 900));
		products.add(new Product(912, "One Plus", 32000.00, "mobile", 100));
		products.add(new Product(88, "HP Printer", 19000.00, "computer", 100));
		
		/*
		 * Commonly Used HIgh Order Functions
		 * Intermediary:
		 * map
		 * filter
		 * limit
		 * skip
		 * flatMap
		 * merge
		 * 
		 * Terminal Operation:
		 * sort
		 * reduce
		 * forEach
		 * collect
		 */
		
		// Higher order functions can only be applied on stream
		products.stream().filter(p -> p.getCategory().equals("mobile")).forEach(p -> System.out.println(p));
		
		System.out.println("*******");
		System.out.println("Mobile Names");
		
		products.stream()
			.filter(p -> p.getCategory().equals("mobile"))
			.map(p -> p.getName())
			.forEach(name -> System.out.println(name));
		
		System.out.println("********");
		// Method Reference - shortcut for lambda
		products.stream().filter(p -> p.getCategory().equals("mobile")).forEach(System.out::println);
		
		System.out.println("********");
		List<Product> mobiles = products.stream().filter(p -> p.getCategory()
				.equals("mobile"))
				.collect(Collectors.toList());
		
		System.out.println(mobiles);
		
		System.out.println("********");
		double sum = products.stream().map(p -> p.getPrice()).reduce(0.0, (v1, v2) -> v1 + v2);
		System.out.println(sum);
		
		DoubleSummaryStatistics stats = products.stream()
				.collect(Collectors.summarizingDouble(p -> p.getPrice()));
		
		System.out.println("Max: " + stats.getMax());
		System.out.println("Min: " + stats.getMin());
		System.out.println("Avg: " + stats.getAverage());
		System.out.println("Sum: " + stats.getSum());
	}
}