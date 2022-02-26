package com.abhay.language.streams.language.bulk;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.abhay.language.streams.language.bulk.Language.LanguageType;

public class LanguageBulkOperations {

	public static void main(String[] args) {
		 ArrayList<Language> langs = new ArrayList<>(); 
		 langs.add(new Language("C", Language.LanguageType.HARD, "C langauge",20.0)); 
		 langs.add(new Language("C++", Language.LanguageType.HARD, "C++ language",35.0)); 
		 langs.add(new Language("Java", Language.LanguageType.OK, "Java language",43)); 
		 langs.add(new Language("C#", Language.LanguageType.OK, "C#",30)); 
		 langs.add(new Language("Javascript", Language.LanguageType.HARD, "Javascript Language",35)); 
		 langs.add(new Language("SQL", Language.LanguageType.EASY, "SQL Database",40));
		 
		 //1. suppose you want to list the name of each lang on the console.
		 langs.stream().forEach(lang->System.out.println(lang));//lambad expression
		 langs.stream().forEach(System.out::println);//method reference
		 //2...Filter based on language type as Hard
		 //List<Language> hardLangList =
		 System.out.println("##############Filter by Hard language###############");
		 
		 langs.stream().filter(lang->lang.type.equals(LanguageType.HARD)).forEach(System.out::println);
		 //Methods that Return Streams Explanation
		 //most comonly used methods are distinct(), sorted(), sorted(Comparator),filter() 
		 
		 
		 //Mapping Methods		 Return		 Description		 <R> Stream<R>
		 //map  , mapToInt/Long/Double, mapToObj, applying the mapper function 
		 
		 //Terminal and Aggregate
		 //Retrun Type   Operations
		 //void          foreach(), foreachOrdered()
		 //long          count() 
		//Optional<T>     min(), max(), average()
		 //resultType sum(), summaryStatistics() ---getCount(),getSum(), getAverage(),getMax/Min() 
		 
		 
		 //For example, suppose the Language class included a public field named price.
         //To calculate the average price of all the languages, you would first have to convert the stream of Language objects to a stream of doubles.
		 
		  OptionalDouble avg = langs.stream() 
		            .mapToDouble(s -> s.price) 
		            .average();
		  if (avg.isPresent()) 		  {		     System.out.println("Average = "   + avg.getAsDouble());	  }
		
		  langs.parallelStream() 
	       .forEach(s -> System.out.println(s));

	}
}
