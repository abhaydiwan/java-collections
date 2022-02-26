package com.abhay.language.streams.build;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.abhay.language.streams.cakes.Cake;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;


public class StreamGenerationExamples {

	
	public static void main(String[] args) {
		String testString = "String";
	    IntStream intStr = testString.chars();
	    intStr.forEach(i->System.out.println(i));
	    
	    Stream<Character> chars = testString.chars().mapToObj(c->(char)c);
	    chars.forEach(s->System.out.print(s));
	    System.out.println("");
	    
		//alternative way is codePoints()
	    IntStream intCodeStr = testString.codePoints();
	    intCodeStr .forEach(i->System.out.println(i));
	    
	    Stream<Character> chars1 = testString.codePoints().mapToObj(c->(char)c);
	    chars1.forEach(s->System.out.print(s));
	    
	    List<String> cities = Arrays.asList( "London","Sydney",  "Colombo", "Cairo","Beijing");
	    //filter citiies starting with c and make them upper case...sort the values...	
	    cities.stream()
	    		  .filter(a -> a.startsWith("C"))
	    		  .map(String::toUpperCase)
	    		  .sorted()
	    		  .forEach(System.out::println);
	    		
	    		
	  // converting files into streams and then perform operations..../practice/src/main/java/com/abhay/language/streams/buildIndex.txt
	    try {
			/*
			 * Stream<String> lines = Files.lines(Path.of("C:\\tmp\\buildIndex.txt"),
			 * StandardCharsets.UTF_8); lines.forEach(System.out::println);
			 */
	    	try(Stream<String> lines = 
	    		    Files.lines(Path.of("C:\\tmp\\buildIndex.txt"), StandardCharsets.UTF_8)) {
	    		    lines.forEach(System.out::println);
	    		}
			System.out.println("##################Filtering by Data####################");
			List<String> strList = Files
					  .readAllLines(Path.of("C:\\tmp\\buildIndex.txt"));
					strList.stream().filter(line->line.startsWith("A")).
					forEach(System.out::println);
					long count = strList.stream().filter(line->line.startsWith("A")).count();
					System.out.println(count);
			System.out.println("###################Splitting Words adn Eliminate Duplicates###################");
			try(Stream<String> lines=Files.lines(Path.of("C:\\tmp\\buildIndex.txt"))){
				Stream<String> words = lines.flatMap(line->Stream.of(line.split("\\W+")));
				Set<String> distinctWords = words.collect(Collectors.toSet());
				System.out.println(distinctWords);
			}		
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
