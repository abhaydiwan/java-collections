package com.abhay.language.arrays.sort;

import java.util.Arrays;

public class MergeSort2 {
    private static void merge(int[] result,
                              int[] left, int[] right) {
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < result.length; i++) { ///for loop till the lenght of outer array
             ///or condition
            if (t2 >= right.length   || (t1 < left.length && left[t1] <= right[t2])) {

                System.out.println("righ length"+right.length);
                result[i] = left[t1];
                t1++;
            } else {
                result[i] = right[t2];
                t2++;

            }
        }
    }

    public static void sort(int[] arr) {
        if (arr.length > 1) {
            int[] left = leftHalf(arr);
            int[] right = rightHalf(arr);
            sort(left);
            sort(right);
            merge(arr, left, right);
        }
    }
    private static int[] leftHalf(int[]arr) {
        int size = arr.length / 2;
        int[] left = new int[size];
        //System.arraycopy(arr, 0, left, 0, size);
        for (int i = 0; i < size; i++) {
            left[i] = arr[i];
        }
        return left;
    }
    private static int[] rightHalf(int[] arr) {
        int size1 = arr.length / 2;
        int size2 = arr.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = arr[i + size1];
        }
        return right;
    }

    public static void main(String[] args) {

        int arr[] = { 12, 11, 13, 5, 6, 7,5,8,11,34,14 };
        System.out.println("Given Array");
        printArray(arr);
        sort(arr);
        System.out.println("Sorted Array");
        printArray(arr);


    }
    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
