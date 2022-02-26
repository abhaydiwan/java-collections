package com.abhay.language.arrays.maths.fun;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class LargestNumber {

	public static void printLargestNumber(Vector<String> array) {
		Collections.sort(array, new Comparator<String>() {
			@Override
			public int compare(String X, String Y) {
				String XY = X + Y;
				String YX = Y + X;
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		Iterator itr = array.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next());
		}
		System.out.println("########");
	}
	
	public static void printLargestNumberStr(Vector<String> array) {
		array.stream().sorted(new Comparator<String>() {
			@Override
			public int compare(String X, String Y) {
				String XY = X + Y;
				String YX = Y + X;
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		}).forEach(System.out::print);
		
		System.out.println("########");
		array.stream().sorted((X,Y) ->{  
		        String XY = X + Y;
				String YX = Y + X;
				return XY.compareTo(YX) > 0 ? -1 : 1;
		      }).forEach(System.out::print);;
			
	
	}
	public static void main(String[] args) {
		
		Vector<String> arr;
        arr = new Vector<>();
 
        // output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargestNumber(arr);
        printLargestNumberStr(arr);
        
	}
}
