package com.abhay.language.regex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegExExamples {

	public static void main(String[] args) {
		///read something from a files
		List<String> words = List.of("Seven", "even", "Maven", "Amen", "eleven");
		Pattern p = Pattern.compile(".even");
		Predicate<String> emailFilter = Pattern.compile("^(.+)@example.com$").asPredicate();
		Predicate<String> evenFilter = Pattern.compile(".even").asPredicate();
		
        List<String> even= words.stream().filter(evenFilter).collect(Collectors.toList());
	    even.forEach(s->System.out.println("predicate filter::"+s));
	       
		//Loop the list and find even 
		for (String word:words) {
			Matcher m = p.matcher(word);
			System.out.println(word);
			if(m.matches()) {
				System.out.printf("%s matches%n", word);
			}
		}
		
		List<String> numbers = Arrays.asList("1", "20", "A1", "333", "A2A211");
        //only digits  
		numbers.stream().filter(x->x.matches("\\d+")).forEach(n->System.out.println(n));
		//replace all with # then you need to have map...transformation case
		numbers.stream().map(x->x.replaceAll("\\d+","#")).forEach(n->System.out.println(n));
       //Numbered references: These are written as $n, where n is a number, such as $1, $2, and $3, which represent a reference to each of the captured groups in the regular expression
		//Named references: These are written as ${groupName}, where groupName is the name of the captured group in the regular expression
		//To place a literal dollar or literal backslash in the replacement string, we need to escape these characters using double backslash (\\).
		//Back-reference is used in the regular expression pattern itself and is written as \1,\2,\3, and so on for a numbered group's back-reference and \k<groupName> 
		//for a named group's back-reference. However, replacement reference is either written as $1, $2, $3, for a numbered group's reference 
		//or ${groupName} for a named group's reference.
		
		//To replace all the semi-colons with hyphens - input.replaceAll(";", "-"); 
		//To remove all the non-digits from the input, we can use:  - input = input.replace("\\D+", ""); 
		String remove= "You are doing 123 great 345";
		System.out.println("You there "+remove.replaceAll("\\D+", ""));
		
		//Note that we are replacing multiple occurrences of non-word characters only and not replacing multiple occurrences of word characters.
		// our input string 
	    String input = "Let''''''s learn::: how to    write cool regex..."; 
	    // call replaceAll and assign replaced string to same variable 
	    input = input.replaceAll("(\\W)\\1+", "$1"); 

	    // print the result 
	    System.out.printf("Replaced result: %s%n", input); 
          
	}
	
}
