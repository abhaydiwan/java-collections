package com.abhay.language.hmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashmapOperations {
public static void main(String[] args) {
	 Map<String,String> gfg = new HashMap<String,String>();
     
     // enter name/url pair
     gfg.put("GFG", "geeksforgeeks.org");
     gfg.put("Practice", "practice.geeksforgeeks.org");
     gfg.put("Code", "code.geeksforgeeks.org");
     gfg.put("Quiz", "quiz.geeksforgeeks.org");
      
     // using for-each loop for iteration over Map.entrySet()
     for (Map.Entry<String,String> entry : gfg.entrySet())
         System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
     // using keySet() for iteration over keys
     for (String name : gfg.keySet())
         System.out.println("key: " + name);
      
     // using values() for iteration over values
     for (String url : gfg.values())
         System.out.println("value: " + url);
     
     // using iterators
     Iterator<Map.Entry<String, String>> itr = gfg.entrySet().iterator();
      
     while(itr.hasNext())
     {
          Map.Entry<String, String> entry = itr.next();
          System.out.println("Key = " + entry.getKey() +
                              ", Value = " + entry.getValue());
     }
     
}
}
