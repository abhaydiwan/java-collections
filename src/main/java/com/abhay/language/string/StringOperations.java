package com.abhay.language.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringOperations {

	// Most of the string opreations used following patterns
	// for (int i=o; i<str.length; i++)
	// check Character.isWhitespace(str.charAt(i))
	// check Character.isDigit(str.charAt(i))
	// Character.codePointAt - An int value, representing the index of the character
	// to return
	// RegEx to remove white space str.replaceAll("\\s+", "");
	// Collections.frequency(Collection, object)
	// String[] arr = str.split("\\W"); how to build an string[] from the words in paragraph
	// isUniqueCharacters
	public static boolean isUniqueCharcters(String str) {
		//
		Integer MAX_CODE = 65535;
		Map<Character, Boolean> chars = new HashMap<Character, Boolean>();
		for (int i = 0; i < str.length(); i++) {
			// fetching index value
			if (str.codePointAt(i) <= MAX_CODE) {
				if (!Character.isWhitespace(str.charAt(i))) {
					if (chars.get(str.charAt(i)) != null) {
						return false;
					} else {
						chars.put(str.charAt(i), true);
					}
				} else {
					System.out.println("Beyond Range");
					return false;
				}
			}
		}
		return true;
	}

	// Encoded String whitespace with---%020%
	public static char[] encodedString(String str) {
		// to build the enocded string you need to calucalte the length
		int countWS = 0;
		/*
		 * * for(Character ch: str.toCharArray()) { if(ch.isWhitespace(ch)) { countWS++;
		 * } }
		 */
		for (int i = 0; i < str.length(); i++) {
			if (Character.isWhitespace(str.charAt(i))) {
				countWS++;
			}
		}
		// now you have ws
		char[] encodedStr = new char[str.length() + countWS * 2];
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			// if you see the whitespace then
			if (Character.isWhitespace(str.charAt(i))) {
				encodedStr[index] = '0';
				encodedStr[index + 1] = '2';
				encodedStr[index + 2] = '%';
				index = index + 3;
			} else {
				encodedStr[index] = str.charAt(i);
				index++;
			}
		}
		return encodedStr;

	}

	// extracting integers
	// StringBuilder temp
	// check for Character.isDigit()
	// List result
	public static List<Integer> extractingIntegers(String str) {
		List<Integer> result = new ArrayList<Integer>();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				temp.append(ch);
			} else {
				if (temp.length() > 0) {
					result.add(Integer.parseInt(temp.toString()));
					temp.delete(0, temp.length());
				}
			}
		}
		return result;
	}

	// Remove white space using regex \\s+
	public static void removeWhiteSpace(String str) {
		String stringWithoutSpaces = str.replaceAll("\\s+", "");
		System.out.println(stringWithoutSpaces);
	}

	// .replaceAll("[,.!?;:]", "$0 ") replace special character with whitespace
	public static void removeSpecialCharWithSpace(String str) {
		String stringWithoutSpaces = str.replaceAll("[1.,?;:]", "$0 ").replaceAll("\\s+", " ");
		System.out.println(stringWithoutSpaces.length());
		System.out.println(stringWithoutSpaces);
	}

	// find a duplicate word in a string
	public static void removeDuplicate(String str) {
		//
		/*
		 * String regex = "\\b(\\w+)(\\W+(?i:\\1)\\b)+";//case in sensitive search
		 * Pattern p = Pattern.compile(regex); Matcher m = p.matcher(str); String
		 * input=""; if (m.find()){ System.out.println(m.replaceAll("$1")); input =
		 * m.replaceAll("$1"); } System.out.println(input);
		 */
		String[] words = str.split("\\W");
		// for(String s : words) {System.out.println(s);}
		// you have to store the duplicate words...
		Map<String, Integer> word_map = new HashMap<String, Integer>();
		for (String word : words) {
			if (word_map.get(word) != null) {
				word_map.put(word, word_map.get(word) + 1);
			} else {
				word_map.put(word, 1);
			}
		}
		// you can store it in a hashset
		Set<String> word_set = word_map.keySet();
		word_set.forEach(s -> System.out.println(s));
		for (String s : word_set) {
			System.out.println(s);
		}

	}

	public static void findDuplicateWords(String str) {
		str.toLowerCase();
		String[] words = str.split("\\W");
		List<String> repeatedWords = new ArrayList<String>();
		Set<String> uniqueWords = new HashSet<String>();
		for (String s : words) {
			if (!uniqueWords.add(s)) {
				repeatedWords.add(s);
			}
		}
		repeatedWords.stream().forEach(s -> System.out.println(s));
	}

	// use Collections.frequency
	public static void duplicateFrequency(String str) {
		// Converting given Input String to lowerCase
		str = str.toLowerCase();
		/*
		 * Split the given Input String into words using built-in split() method
		 */
		// String[] strArray = str.split(" ");
		String[] strArray = str.split("\\W");
		// Converting String array to List of String
		List<String> listOfWords = Arrays.asList(strArray);
		/*
		 * Declare HashSet of String that will contain unique words
		 */
		HashSet<String> uniqueWords = new HashSet<>(listOfWords);
		for (String word : uniqueWords) {
			if (Collections.frequency(listOfWords, word) > 1)
				System.out.println(" " + word + ":" + Collections.frequency(listOfWords, word));
		}

		
		//String input = "bookkeeper";
		//split the word
		//Stream.of(input.toLowerCase().split(""))
		
		
	}
	

    public static String reversedString(String str) {
    	
    	String reverse = new String("");
    	for(int i=0;i<str.length();i++) {
    		reverse=str.charAt(i)+reverse;
    	}
    	return reverse;
    }	
    
    public static void sortString(String str) {
    	String[] arr = str.toLowerCase().split("\\W");
    	for(int j = 0; j < arr.length; j++)
         {
             for(int i = j + 1; i < arr.length; i++)
             {
                 if(arr[i].compareTo(arr[j]) < 0)
                 {
                     String t = arr[j];
                     arr[j] = arr[i];
                     arr[i] = t;
                 }
             }
             System.out.println(arr[j]);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("############starts isUniqueCharcters(str)####################");
		String str = "Helo Wor is great";
		System.out.println(isUniqueCharcters(str));
		System.out.println("############Ends isUniqueCharcters(str)####################");
		System.out.println("############starts encodedString(str)####################");
		System.out.println(encodedString(str));
		System.out.println("############Ends encodedString(str)####################");

		System.out.println("############starts extractingIntegers(str)####################");
		String withInetger = "Hello 123 how are you 1 at 2 let 8 if it fine";
		System.out.println(extractingIntegers(withInetger));
		System.out.println("############Ends extractingIntegers(str)####################");
		System.out.println("############starts removeWhiteSpace(str)####################");
		removeWhiteSpace(str);
		System.out.println("############Ends removeWhiteSpace(str)####################");
		System.out.println("############starts removeSpecialCharWithSpace(str)####################");
		String special = "Helo, Wor! is, great?";
		removeSpecialCharWithSpace(str);
		System.out.println("############Ends removeSpecialCharWithSpace(str)####################");
		System.out.println("############starts removeDuplicate(str)####################");
		String remoDuplicate = " Hi, I am Hritik and I am a programmer. ";
		removeDuplicate(remoDuplicate);
		System.out.println("############Ends removeDuplicate(str)####################");
		System.out.println("############starts findDuplicateWords(str)####################");
		String findDuplicate = "Java is a programming language. Python is also a programming language";
		findDuplicateWords(findDuplicate);
		System.out.println("############Ends findDuplicateWords(str)####################");
		System.out.println("############starts duplicateFrequency(str)####################");
		String freqDuplicate = "Java is a programming language. Python is also a programming language. Language is good to learn";
		duplicateFrequency(freqDuplicate);
		System.out.println("############Ends duplicateFrequency(str)####################");

		System.out.println("############starts reversedString(str)####################");
		String revString = "Hello world";
		System.out.println(reversedString(revString));
		System.out.println("############Ends reversedString(str)####################");

		//sortString
		System.out.println("############starts sortString(str)####################");
		sortString(freqDuplicate);
		System.out.println("############Ends reversedString(str)####################");

	}

}
