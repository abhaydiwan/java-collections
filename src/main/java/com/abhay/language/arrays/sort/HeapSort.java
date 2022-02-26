package com.abhay.language.arrays.sort;

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {23,12,11,1,5,8,9};
        heapsort(arr);
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
    ///build on heap logic...like binary search tree
    public static void heapsort(int[] arr){
        int length = arr.length;
        buildheap(arr,length);
         while(length >1){
             swap(arr, 0,length-1);
             length--;
             heapify(arr,length,0);
         }

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
}
