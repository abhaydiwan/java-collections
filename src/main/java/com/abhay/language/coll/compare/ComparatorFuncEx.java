package com.abhay.language.coll.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

class Student {
	String name;
	Integer id;
	Double gpa;

	public Student(String n, int i, double g) {
		name = n;
		id = i;
		gpa = g;
	}

	@Override
	public String toString() {
		return name + " " + id + " " + gpa;
	}
}

//we may want compare student based on name or id or gpa
public class ComparatorFuncEx {

	public static void main(String[] args) {
		// Suppose a program needs to compare students based on grade point average. The
		// program should write a function that extracts the gpa field from a Student
		// object.
		// This will be the key used for comparison of two students.

		Function<Student, Double> gpaKey = x -> x.gpa;

		// A Comparator<Student> object can be created that uses the function to extract
		// the gpa field from two Student objects and then compare them based on the
		// natural ordering of Doubles.

		Comparator<Student> byGpa = Comparator.comparing(gpaKey);

		Comparator<Student> byGpa2 = Comparator.comparing(x -> x.gpa);

		Student s1 = new Student("Larry", 1000, 3.82);
		Student s2 = new Student("Libby", 1001, 3.76);
		System.out.println(byGpa.compare(s1, s2));
		System.out.println(byGpa2.compare(s1, s2));

		// compare by id
		Comparator<Student> byId = Comparator.comparing(x -> x.id);
		System.out.println(byId.compare(s1, s2));

		// A third comparator can be defined that compares students based on name. This
		// comparator lexicographically compares
		// each character in the two name strings and displays -8, since “a” precedes
		// “i” in the alphabet by eight letters.

		Comparator<Student> byName = Comparator.comparing(x -> x.name);
		System.out.println(byName.compare(s1, s2));

		/*
		 * Comparator<Student> byNameConsonants = Comparator.comparing( x -> x.name,
		 * (x,y) -> removeVowels(x).compareTo( removeVowels(y)));
		 * System.out.println(byNameConsonants.compare(s1,s2));
		 */

		List<Student> students = Arrays.asList(new Student("Joseph", 1623, 3.54), new Student("Annie", 1923, 2.94),
				new Student("Sharmila", 1874, 1.86), new Student("Harvey", 1348, 1.78),
				new Student("Grace", 1004, 3.90), new Student("Annie", 1245, 2.87));

		Comparator<Student> byGpaCeil = Comparator.comparing(x -> x.gpa, (x, y) -> (int) (Math.ceil(x) - Math.ceil(y)));
		students.sort(byGpaCeil);
		students.forEach(x -> System.out.println(x));
		System.out.println("$$$$$$$$$$$$$$$$$$$$#######################");

		// Comparators can operate on Java arrays in a fashion similar to lists through
		// the use of the Arrays class. Suppose the program stored the students in a
		// Java array instead.
		Student[] studentsArray = { new Student("Joseph", 1623, 3.54), new Student("Annie", 1923, 2.94),
				new Student("Sharmila", 1874, 1.86), new Student("Harvey", 1348, 1.78),
				new Student("Grace", 1004, 3.90), new Student("Annie", 1245, 2.87) };
		Student[] studentsCopy = Arrays.copyOf(studentsArray, studentsArray.length);
		// The Array class’s static sort method sorts a Java array using a specified
		// comparator. In the following example, the Java array is sorted in the same
		// order as the list.

		Comparator<Student> byGpaCeil1 = Comparator.comparing(x -> x.gpa,
				(x, y) -> (int) (Math.ceil(x) - Math.ceil(y)));
		Arrays.sort(studentsArray, byGpaCeil1.thenComparing(x -> x.id).thenComparing(x -> x.name));
		for (Student s : studentsArray)
			System.out.println(s);
	}
	
	
}
