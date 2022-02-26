package com.abhay.language.arrays.sort;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static int[] mergeTwoArray(int p[], int q[]){
      ///first get the index of both the array
        int pLast = p.length - q.length;
        int qLast = q.length;
        if(pLast<0){ throw new IllegalArgumentException("p cannot be less than q");}

        //array index will be one value less than length
        int pIdx = pLast -1;
        int qIdx= qLast-1;
        int mIdx = pLast+qLast-1; //last index in p
        //you have to start from the last element in q
        while(qIdx >= 0){
            //compare pidx and qidx
            if(pIdx >=0 && p[pIdx] > q[qIdx]){
                p[mIdx] = p[pIdx];
                pIdx--;
            }else{
                p[mIdx] = q[qIdx];
                qIdx--;
            }
           mIdx--;
        }//end of while
        return p;
    }

    public static void main(String[] args) {
        int[] p = new int[5];
        int[] q = new int[2];
        p[0]=1;        p[1]=3;       p[2] =8; q[0]=2; q[1]=4;

        int[] r=mergeTwoArray(p,q);

        Arrays.stream(r).forEach(s -> System.out.println(s));
    }
}
