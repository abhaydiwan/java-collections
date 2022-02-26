package com.abhay.language.arrays;

import java.util.Arrays;

public class ArrayDuplicate {

	public static void main(String[] args) {
		
		int[] arr = {1,4,5,7,1,5,8,9,3,2,4,8,4};
		
		findDuplicateSort(arr);
		
	}
	
	private static void findBruteFroce(int[] inputArray){
        //you will run two for loops and match if any one matching or not
        // O(N*N)
        for (int i=0; i<inputArray.length-1;i++){
            for(int j=i;j<inputArray.length;j++){
                if (inputArray[i]==inputArray[j]){
                    System.out.printf("Found duplicate elements: %d,%d",inputArray[i],inputArray[j]);
               }
            }
          }
       }

    //another way is to sort an array then check next element if it macthes then done
    private static void findDuplicateSort(int[] inputArray){
        Arrays.sort(inputArray);
        for(int i=0; i<inputArray.length-1;i++){
            if (inputArray[i]==inputArray[i+1]){
                System.out.printf("Found duplicate elements: %d,%d",inputArray[i],inputArray[i+1]);
                System.out.println();
            }
        }
    }
}
