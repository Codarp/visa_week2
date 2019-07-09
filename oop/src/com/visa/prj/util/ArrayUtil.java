package com.visa.prj.util;

import java.util.Arrays;

public class ArrayUtil {
	
	// Comparable refers to anything which is comparable.
	// This applies Open Close Principle.
	public static void sort(Comparable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			for (int j = i + 1; j < elems.length; j++) {
				if(elems[i].compareTo(elems[j]) > 0) {
					Comparable temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;
				}
			}
		}
	}
	
	public static int getSum(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	public static void sort(int[] elems) {
//		Arrays.parallelSort(elems);
		
		for (int i = 0; i < elems.length; i++) {
			for (int j = 0; j < elems.length-i-1; j++) {
				if (elems[j] > elems[j+1]) {
					int temp = elems[j];
					elems[j] = elems[j+1];
					elems[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 
	 * method to return number of occurrence of "no" in an array
	 * @param elems
	 * @param no
	 * @return
	 */
	public static int getCount(int[] elems, int no) {
		int count = 0;
		for (int i = 0; i < elems.length; i++) {
			if (elems[i] == no)
				count++;
		}
		return count;
	}
	
	public static int[] convert(int[][] data) {
		
		int temp[] = new int[data.length*data[0].length];
		
		int k = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				temp[k++] = data[i][j];
			}
		}
		return temp;
	}
}
