package com.abhay.language.coll.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompartorEmpEx {

	public static void main(String[] args) {
		// lets filter inetger greater than 10

		Integer[] numbers = { 3, 12, 45, 23, 4, 11, 7 };
		List<Integer> nListGT10 = Arrays.asList(numbers).stream().filter(n -> n > 10).collect(Collectors.toList());
		nListGT10.forEach(System.out::println);

//create an employees array then apply stream functions...		
		Employee[] emps = { new Employee("Abhay", 1001, 30000.00), new Employee("Aditi", 1002, 55000.00),
				new Employee("Apurva", 1003, 53000.00), new Employee("Ryan", 1004, 60000.00) };
		// compare by name
		Arrays.asList(emps).sort(Comparator.comparing(Employee::getSalary));
		System.out.println("\nSorted by the last name, first name, and dob:");
		for (Employee e : emps) {
			System.out.println(e.name);
		}
	}
}

class Employee {

	String name;
	Integer id;
	Double salary;

	public Employee(String name, Integer id, Double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}