package com.abhay.language.arrays;

public class ArrayMatrixProblem {
 
	public static void main(String[] args) {
	
		 int a[][] = { {1, 2, 3, 4},
                 {5, 6, 7, 8},
               {9, 10, 11, 12},
               {13, 14, 15, 16} };
		 displayMatrix(a);
			
		 //rotate matrix
		 rotateWithTranspose(a);
		 //rotateRing(a);
		 displayMatrix(a);
		
		 int[][] arr2D = {{17, 13, 19, 22}, {12, 18, 25, 20}, {15, 18, 21, 24}, {19, 23, 23, 22}, {18, 20, 21, 26}};
	       totalSum(arr2D);	 
 }
 
	public static boolean rotateWithTranspose(int m[][]) {
		  transpose(m);
		  for (int row = 0; row < m.length; row++) {
			  for(int col=0,k=m[0].length-1;col<k;col++,k--)
			  {		  int temp = m[col][row];
			  m[col][row] = m[k][row];
		      m[k][row] = temp;
		     }
		  }
		  return true;
	}
		  
	private static void transpose(int m[][]) {
		  for (int i = 0; i < m.length; i++) {
		    for (int j = i; j < m[0].length; j++) {
		      int temp = m[j][i];
		      m[j][i] = m[i][j];
		      m[i][j] = temp;
		    }
		  }
		}
	
	public static boolean rotateRing(int[][] m) {
		  int len = m.length;
		  // rotate counterclockwise
		  for (int i = 0; i < len / 2; i++) {
		    for (int j = i; j < len - i - 1; j++) {
		      int temp = m[i][j];
		      // right -> top 
		       m[i][j] = m[j][len - 1 - i];
		       // bottom -> right 
		       m[j][len - 1 - i] = m[len - 1 - i][len - 1 - j];
		       // left -> bottom 
		       m[len - 1 - i][len - 1 - j] = m[len - 1 - j][i];
		       // top -> left
		       m[len - 1 - j][i] = temp;
		     }
		   }                 
		   return true;
		 }
 
	public static void totalSum(int[][] arr2D) {
		int total = 0;
		for (int row = 0; row < arr2D.length; row++) {
		    for (int col = 0; col < arr2D[0].length; col++) {
		        total += arr2D[row][col];
		    }
		}
		 
		System.out.println("total is:"+total);
		
	}
	public static void displayMatrix(int[][] arr) {
	
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j] + " ");
		    	 }
			System.out.print("\n");
			}
	}
 
}
