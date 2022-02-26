package com.abhay.language.streams.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSortingEx {
	public static void main(String[] args) {

		String str01 = "Lorem adipising ipsum dolor sit Lorem amet Consectetur adipising elit Lorem ipsum dolor";

		List<String> list = Stream.of(str01).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
				.collect(Collectors.toList());

		Map<String, Integer> wordCounter = list.stream()
				.collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

		System.out.println("wordCounter::" + wordCounter);

		String[] chars = { "A", "B", "C", "A", "C", "A" };
		Map<String, Long> freq = Stream.of(chars)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(freq);
		Map<String, Long> freqWithoutStream = new HashMap<>();
		for (String s : chars) {

			freqWithoutStream.merge(s, 1L, Long::sum);
		}

		System.out.println(freqWithoutStream);

		Map<String, Integer> freqOld = new HashMap<>();
		for (String s : chars) {
			int prev = 0;
			// get the previous count
			if (freqOld.get(s) != null) {
				prev = freqOld.get(s);
			}
			freqOld.put(s, prev + 1);
		}

		System.out.println(freqOld);
		String input = "bookkeeper";
		// split the word
		Stream.of(input.toLowerCase().split(""))
				// map char with count
				// .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))

				// fetch entryset collection
				.entrySet()
				// stream it
				.stream()
				// map key and value
				.map(e -> e.getKey() + e.getValue() + " ")
				// loop it
				.forEach(System.out::print);

		Stream.of(input.toLowerCase().split(""))
				// Function.identity()
				//
				// .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				///// sorted...Map.Entry.comparingByKey
				.sorted(Map.Entry.comparingByKey()).map(e -> e.getKey() + e.getValue() + " ")
				.forEach(System.out::print);

		String str = "Java is a programming language. Python is also a programming language. Language is good to learn";
		str = str.toLowerCase();
		/*
		 * Split the given Input String into words using built-in split() method
		 */
		// String[] strArray = str.split(" ");
		String[] strArray = str.split("\\W");

		Arrays.stream(strArray)
				// map word with count
				// .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))

				// fetch entryset collection
				.entrySet()
				// stream it
				.stream()
				// map key and value
				.map(e -> e.getKey() + e.getValue() + " ")
				// loop it
				.forEach(System.out::print);
	}
}
