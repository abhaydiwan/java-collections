package com.abhay.language.arrays.sort;

public class InsertionSort {

    static void sort(int arr[]){
     for(int i=1; i<arr.length;i++){
         int key = arr[i];
         int j = i-1;//previoud value of i
         //now run the while llop in reverse order
         while(j>=0 && arr[j]>key){
             //swap values
             arr[j+1]=arr[j];
             j--;
         }
         arr[j+1]=key; //next element as key
     }

    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        sort(arr);
        printArray(arr);
    }
}
