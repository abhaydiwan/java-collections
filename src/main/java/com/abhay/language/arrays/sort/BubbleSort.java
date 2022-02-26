package com.abhay.language.arrays.sort;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] arr){
        //two for loop and compare and swap the values....
        //O(N*N) Adaptive///stable
        for (int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                //swap values using temp variables
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                }
            }//j for loop
        }// i for loop
        return arr;
    }
    public static void main(String[] args) {
        int[] arrSort = {8,9,1,5,7,2};
        int[] res = bubbleSort(arrSort);
        Arrays.stream(res).forEach(i-> System.out.println(i));
    }
}
