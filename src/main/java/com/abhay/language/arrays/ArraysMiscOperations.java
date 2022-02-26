package com.abhay.language.arrays;

import java.util.*;

public class ArraysMiscOperations {

	public static void main(String[] args) {
          
		int[] arr = {23,45,6,7,9,34,55,67,33,27};
		System.out.println("#########find the largest element in an array starts here##########");
 		int max = largestElement(arr);
 		System.out.println(max);
		System.out.println("#########find the largest element in an array ends here##########");
		int[] arr01 = {23,45,6,7,9,34,55,67,13,17};
		System.out.println("####find duplicate###");
		System.out.println(findDuplicate(arr01));
		
		System.out.println(findSumofTwo(arr01,51));
		
	}
	
	public static int largestElement(int[] arr) {
		int max= arr[0];
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
	
 public static boolean findDuplicate(int[] arr) {
     Arrays.sort(arr);
     
     for(int i=0;i<arr.length-1;i++) {
    	 if(arr[i]==arr[i+1]) {
    		 return false;
    	 }
     }
	 
	 return true;
 }	
	
 public static boolean findSumofTwo(int[] arr, int val) {
  Set<Integer> foundValues = new HashSet<Integer>();
    for(int a : arr) {
    	if(foundValues.contains(val-a)) {
    		return true;
    	}
    	foundValues.add(a);
     } 
	 return false;
 }
 
}//end of the class ArraysMiscOperations
