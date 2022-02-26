package com.abhay.language.arrays.sort;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Given Array");
        printArray(arr);
        sort(arr,0,arr.length-1);
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
     static void sort(int[] arr, int l, int r) {
        //find the indexes...
         if(l<r){
              // 0 +
             int m = l+ (r-l)/2;
        //left array sort
          sort(arr,l,m);
        //right array sort
          sort(arr,m+1,r);
        // merge all elements
          merge(arr,l,m,r);
         }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        //you have to merge all elements of the array
        //create temp arrays
        //left array
        int n1 = m - l + 1;
        //right array
        int n2 = r - m;
        //create two temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        //Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        //initial index of first and second array
        int i = 0;
        int j = 0;

        //initial index of merged sub array

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
}
