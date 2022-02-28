package com.abhay.language.coll.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericComparator<T> implements Comparator<T> {

	private String property;

	public GenericComparator(String property) {
		this.property = property;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int compare(Object o1, Object o2) {
		Comparable o1Comparable = getComparable(o1);
		Comparable o2Comparable = getComparable(o2);
		return o1Comparable.compareTo(o2Comparable);
	}

	@SuppressWarnings("rawtypes")
	private Comparable getComparable(Object o) {
		try {
			Object invoke = o.getClass().getMethod(property, new Class[] {})
					.invoke(o, new Class[] {});
			return ((Comparable)invoke);
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		Student1 s1 = new Student1("david");

		Student1 s2 = new Student1("adam");

		List<Student1> list = new ArrayList<Student1>();

		list.add(s1);

		list.add(s2);

		System.out.println(list);

		java.util.Collections.sort(list, new GenericComparator<Student1>("getName"));
		System.out.println("After sort :" + list);
	}



	 }
class Student1
{
	private String name;
	Student1(){}
	Student1(String name) {this.name = name;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
}

