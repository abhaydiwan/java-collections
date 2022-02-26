package com.abhay.language.arrays.maths.fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LargestNumber2 {
	
  public static String largestNumber(int[] nums) {
      String[] strArray = Arrays.stream(nums)
              .mapToObj(String::valueOf)
              .toArray(String[]::new);
      
      String result = Arrays.asList(strArray).stream()
      .sorted(new Comparator<String>() {
			@Override
			public int compare(String X, String Y) {
				
				String XY = X + Y;
				String YX = Y + X;
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		}).collect(Collectors.joining());
   
    if(result.startsWith("0")) {
	   return "0";
   }else {
	   return result;
   }
}

public static void main(String[] args) {
    int nums[] = {0,0};
    
   System.out.println(largestNumber(nums));
   
   
}
}
