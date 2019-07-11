package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSecondExample {

	public static void main(String[] args) {
		List<Integer> il = Arrays.asList(1,66,3,77,2);
		List<String> sl = Arrays.asList("one", "two", "three");
		
		print(il);
		print(sl);
		
		// Required for pagination.
		List<Integer> copyInt = new ArrayList<>();
		List<String> copyStr = new ArrayList<>();
		
		copy(copyInt, il);
		copy(copyStr, sl);
	}

	// For this to work both have to be of the same type.
	// i.e. both have to be of String or Integer.
	// PECS Producer Extends Consumer Super.
	private static <T> void copy(List<? super T> dest, List<? extends T> src) {
		for (T o: src) {
			dest.add(o);
		}
	}

	private static void print(List<?> list) {
		for(Object o : list) {
			System.out.println(o);
		}
	}
}
