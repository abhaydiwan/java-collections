package com.abhay.language.streams.grouping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamGroupingEx {
 public static void main(String[] args) {
	
	 List<String> fruits =  Arrays.asList("apple", "apple", "banana","apple", "orange", "banana", "papaya");
     Map<String, Long> result =    fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
     System.out.println(result);
     
     //sorting
     Map<String, Long> finalMap = new LinkedHashMap<>();

     //Sort a map and add to finalMap
     result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
     System.out.println(finalMap);
  
     List<Item> items = Arrays.asList(
             new Item("apple", 10, new BigDecimal("9.99")),
             new Item("banana", 20, new BigDecimal("19.99")),
             new Item("orang", 10, new BigDecimal("29.99")),
             new Item("watermelon", 10, new BigDecimal("29.99")),
             new Item("papaya", 20, new BigDecimal("9.99")),
             new Item("apple", 10, new BigDecimal("9.99")),
             new Item("banana", 10, new BigDecimal("19.99")),
             new Item("apple", 20, new BigDecimal("9.99"))
     );

     Map<String, Long> counting = items.stream().collect(
    		                      ///grouping is done based on Name and Count
             Collectors.groupingBy(Item::getName, Collectors.counting()));

     System.out.println(counting);

     Map<String, Integer> sum = items.stream().collect(
    		///grouping is done based on Name and Summing item quantity
             Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

     System.out.println(sum);
 	//group by price
     Map<BigDecimal, List<Item>> groupByPriceMap = 
			items.stream().collect(Collectors.groupingBy(Item::getPrice));

     System.out.println(groupByPriceMap);

		// group by price, uses 'mapping' to convert List<Item> to Set<String>
     Map<BigDecimal, Set<String>> result2 =
             items.stream().collect(
                     Collectors.groupingBy(Item::getPrice,
                             Collectors.mapping(Item::getName, Collectors.toSet())
                     )
             );

     System.out.println(result2);
 }
}

///we should not use this for some reason...
@Data
@AllArgsConstructor
class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    
  
}