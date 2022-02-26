package com.abhay.language.streams.duplicate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://www.javaprogramto.com/2020/03/java-count-duplicate-characters.html
public class FindDuplicateStrings {

	private static List chars = new ArrayList();

	public static void main(String[] args) {

		// 1...Brute Force

		System.out.println("---------Input 1 ------");
		printCountOfDuplicateCharacter("JavaProgramTo.com");
		System.out.println("---------Input 2 ------");
		printCountOfDuplicateCharacter("aaaabbbcccccdddddd");

		//2....Hashmap
		printCountOfDuplicateCharacterUsingHashMap("bbbcccccddddddaaaa");
        printCountOfDuplicateCharacterUsingHashMap("##^$!%^$!^%@!$^@!kds");
     
        //3..
        printCountOfDuplicateCharMapCompute("bbbcccccddddddaaaa");
        printCountOfDuplicateCharMapCompute("##^$!%^$!^%@!$^@!kds");
        
        //4..
        printCountOfDuplicateCharJava8Stream("bbbcccccddddddaaaa");
        printCountOfDuplicateCharJava8Stream("##^$!%^$!^%@!$^@!kds");
	}
	
	 // ################################################# 2. Approach HashMap#################################################
	// Using hashmap : print count of each character in a given string.
    private static void printCountOfDuplicateCharacterUsingHashMap(String input) {
        Map<Character, Integer> output = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (output.containsKey(ch)) {
                output.put(ch, output.get(ch) + 1);
            } else {
                output.put(ch, 1);
            }
        }
        System.out.println(output);
    }
    
 // ################################################# 3. Approach LinkedHashmap --compute#################################################
    // Using hashmap : print count of each character in a given string.
    private static void printCountOfDuplicateCharMapCompute(String input) {

        Map<Character, Integer> output = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            output.compute(ch, (key, value) -> (value == null) ? 1 : value + 1);
        }
        System.out.println(output);
    }

  // ################################################# 4. intstream --Collectors.goruping By,Collectors.counting#################################################
  // Using hashmap : print count of each character in a given string.
    private static void printCountOfDuplicateCharJava8Stream(String input) {
        // Step 1
        IntStream intStream = input.chars();
        // Step 2
        Stream<Character> charsStream = intStream.mapToObj(ch -> (char) ch);
        // Step 3
        Map<Character, Long> output = charsStream.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        System.out.println(output);

    }

 // ################################################# 5. code points#################################################
    public static Map<String, Long> printCountOfDuplicateCharJava8Surrogate(String input) {

        Map<String, Long> result = input.codePoints().mapToObj(ch -> String.valueOf(Character.toChars(ch)))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        return result;
    }
    
 // ################################################# 1. Brute Force#################################################
  //print count of each character in a given string.
  	private static void printCountOfDuplicateCharacter(String input) {

  		for (int i = 0; i < input.length(); i++) {
  			char ch = input.charAt(i);
  			if (isProcessedChar(ch))
  				continue;
  			int count = 0;
  			for (int j = 0; j < input.length(); j++) {
  				if (ch == input.charAt(j)) {
  					count++;
  				}
  			}
  			System.out.println(ch + " : " + count);
  		}
  		chars.clear();
  	}

  // checking whether the given char is already processed or not.
  	private static boolean isProcessedChar(char ch) {
  		if (chars.contains(Character.toString(ch))) {
  			return true;
  		} else {
  			chars.add(Character.toString(ch));
  		}
  		return false;
  	}


}//end of the class
