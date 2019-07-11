package com.visa.prj.client;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.visa.prj.entity.Product;

public class Task {

	public static void main(String[] args) {
		Product p = new Product(645, "Hp Laptop", 135000.00, "computer", 100);
		Method[] methods = p.getClass().getMethods();
		Map<String, Object> map = new HashMap<>();
		for (Method m : methods) {
			if (m.getName().startsWith("get")) {
				try {
					Object ret = m.invoke(p);
					map.put(m.toString().substring(m.toString().indexOf("get") + 3, m.toString().indexOf("(")), ret);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		map.forEach((k,v) -> System.out.println(k + ":" + v));
		
		Map<String, Integer> map2 = getWordFrequency("java is oop and java is distributed and java is stable")
		.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(
            Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                LinkedHashMap::new));
		System.out.println(map2);
	}
	
	
	public static Map<String, Integer> getWordFrequency(String str) {
		String strArray[] = str.split(" ");
		Map<String, Integer> map = new TreeMap<>();
		Set<String> set = new HashSet<>();
		for (String string : strArray) {
			if (set.add(string)) {
				map.put(string, 1);
			} else {
				map.put(string, map.get(string)+1);
			}
		}
		return map;
	}
}
