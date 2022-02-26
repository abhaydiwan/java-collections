package com.abhay.language.streams.cakes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CakesStream {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile(",");
		try (Stream<String> lines = Files.lines(Path.of("C:\\tmp\\cakes.csv"))) {
			List<Cake> cakes = lines.skip(1).map(line -> {
				String[] arr = pattern.split(line); /// capturing in array format
				          //// creating class instance from each arr index value
				return new Cake(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2].trim()));
			}).collect(Collectors.toList());

			cakes.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
