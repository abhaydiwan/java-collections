package com.abhay.language.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDuplicate {

	public static void main(String[] args) {
		
		int[] arr = {1,4,5,7,1,5,8,9,3,2,4,8,4};
		
		findDuplicateSort(arr);
		
		int[][] test = new int[][]{
            {1, 1, 2, 2, 3, 4, 5},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 1, 1, 1, 1, 1},};

        for (int[] input : test) {
            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
            System.out.println("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)));
        }
        
        for (int[] input : test) {
        	System.out.println("Using streams ");
            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
            System.out.println("After removing duplicates   : ");
           Arrays.stream(input).distinct().forEach(i -> System.out.println(i));
        }
        
        List<Integer> withDupes = Arrays.asList(10, 10, 20, 20, 30, 30, 40, 50); 
        System.out.println("List with duplicates: " + withDupes); 
        List<Integer> withoutDupes = withDupes.stream() .distinct() .collect(Collectors.toList()); 
        System.out.println("List without duplicates: " + withoutDupes);
        //Read more: https://www.java67.com/2018/06/how-to-remove-duplicates-from-stream-in-java8-distinct-example.html#ixzz7MFWsnI4T
        //2d array
        
        String[][] strArrayDeep = new String[][]{{"java", "python"}, {"javascript", "golang"}};
        Arrays.stream(strArrayDeep).flatMap(Arrays::stream).forEach(System.out::println);

        int[][] intArrayDeep = new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}};
        Arrays.stream(intArrayDeep).flatMapToInt(Arrays::stream).forEach(System.out::println);

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
    public static int[] removeDuplicates(int[] numbersWithDuplicates) {

        // Sorting array to bring duplicates together      
        Arrays.sort(numbersWithDuplicates);     
      
        int[] result = new int[numbersWithDuplicates.length];
        int previous = numbersWithDuplicates[0];
        result[0] = previous;

        for (int i = 1; i < numbersWithDuplicates.length; i++) {
            int ch = numbersWithDuplicates[i];

            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;

    }
}


//Read more: https://javarevisited.blogspot.com/2014/01/how-to-remove-duplicates-from-array-java-without-collection-API.html#ixzz7MFWJTCxA

