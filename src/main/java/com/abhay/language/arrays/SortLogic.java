package com.abhay.language.arrays;

import java.util.Arrays;

public class SortLogic {

	public static void bubbleSort(int[] arr) {
	   for(int i=0; i<arr.length;i++) {
		   for(int j=0;j<arr.length-1;j++) {
             if(arr[j]>arr[j+1]) {
            	 swap(arr,j,j+1);
					/*
					 * int temp= arr[j]; arr[j]=arr[j+1]; arr[j+1]=temp;
					 */
             }			   
		   }
	    }	
	   printArray(arr,"Bubble");
	 }
	
	///build on heap logic...like binary search tree
    public static void heapSort(int[] arr){
        int length = arr.length;
        buildheap(arr,length);
         while(length >1){
             swap(arr, 0,length-1);
             length--;
             heapify(arr,length,0);
         }
         printArray(arr,"Heap Sort");
    }
    private static void buildheap(int[] arr, int length) {
        for(int i=0;i<arr.length/2;i++){
            heapify(arr,length,i);
        }
    }
    private static void heapify(int[] arr, int length, int i) {
        ///
        //int i=0 then left will be 1 and right willbe 2 ...i=1 then left will be 3, right 4
        int left = i*2+1;
        int right = i*2+2;
        int greater;
        //find which one is greater and set greater accordingly whether i or left or right and ensure both left and right are less length of an array
        if(left < length &&arr[left]>arr[i]){
            greater=left;
        } else{
            greater=i;
        }
        if(right<length && arr[right]>arr[greater]){
            greater=right;
        }

        if(greater!=i){
            //then you have to swap
            swap(arr,i,greater);
            heapify(arr,length,greater);
        }

    }


    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

public static void printArray(int[] arr,String sort) {
	  System.out.println("######################### Starts :"+sort+"###########################");
	  int n = arr.length;
	for(int i=0;i<n;i++) {
	  System.out.println(arr[i]);
  }
	System.out.println("######################### End: "+sort+"###########################");
 }
}
