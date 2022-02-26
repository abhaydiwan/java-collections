package com.abhay.language.string;

import java.util.stream.Stream;

public class StringLengthStreamEx {
public static void main(String[] args) {
	int sum = Stream.of("this", "is", "a", "stream", "of", "strings")
            .mapToInt(String::length)
            .sum();
    System.out.printf("The sum of the lengths is %d%n", sum);
}
}
