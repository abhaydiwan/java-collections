package com.abhay.language.streams.sorting;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toMap;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GolferSortingEx {
	public static void main(String[] args) {

		SortGolfers sg = new SortGolfers();
//  sg.defaultSort();
//  sg.sortByScoreThenLast();
		sg.sortByScoreThenLastThenFirst();
//   sg.partitionByScore();

	}
}

class SortingDemo {
    private List<String> sampleStrings =
            Arrays.asList("this", "is", "a", "list", "of", "strings");

    // Default sort from Java 7-
    public List<String> alphaSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    // Default sort from Java 8+
    public List<String> alphaSortUsingStreams() {
        return sampleStrings.stream()
                .sorted()
                .collect(toList());
    }

    // Java 7- using Comparator with anonymous inner class
    public List<String> lengthReverseSortWithComparator() {
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        return sampleStrings;
    }

    // Using a lambda as a Comparator with a lambda
    public List<String> lengthSortWithLambda() {
        Collections.sort(sampleStrings,
                (s1, s2) -> s1.length() - s2.length());
        return sampleStrings;
    }

    // Sort by length with sorted
    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(toList());
    }

    // Length sort with comparingInt
    public List<String> lengthSortUsingComparator() {
        return sampleStrings.stream()
                .sorted(comparingInt(String::length))
                .collect(toList());
    }

    // Length sort, then alphabetical
    public List<String> lengthSortThenAlphaSort() {
        Collections.sort(sampleStrings,
                comparingInt(String::length)
                        .thenComparing(naturalOrder()));
        return sampleStrings;
    }

    // Sort by length then alpha using sorted
    public List<String> lengthSortThenAlphaSortUsingSorted() {
        return sampleStrings.stream()
                .filter(Objects::nonNull)
                .sorted(comparingInt(String::length)
                        .thenComparing(naturalOrder()))
                .collect(toList());
    }

    // Sort by length then reverse alpha using sorted
    public List<String> lengthSortThenReverseAlphaUsingSorted() {
        return sampleStrings.stream()
                .filter(Objects::nonNull)
                .sorted(comparing(String::length)
                        .thenComparing(reverseOrder()))
                .collect(toList());
    }
}

class SortingMaps<K extends Comparable<? super K>, V extends Comparable<? super V>> {
    private Map<K, V> map = new HashMap<>();

    public void setMap(Map<K, V> map) {
        this.map = map;
    }

    public Map<K, V> getMap() {
        return map;
    }

    public Map<K, V> getMapSortedByKey() {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    public Map<K, V> getMapSortedByKeyDesc() {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(reverseOrder()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    public Map<K, V> getMapSortedByValue() {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    public Map<K, V> getMapSortedByValueDesc() {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(reverseOrder()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
class SortGolfers {
	private List<Golfer> golfers = Arrays.asList(new Golfer("Jack", "Nicklaus", 68), new Golfer("Tiger", "Woods", 70),
			new Golfer("Tom", "Watson", 70), new Golfer("Ty", "Webb", 68), new Golfer("Bubba", "Watson", 70));

	// default sort is by score
	public void defaultSort() {
		golfers.stream().sorted().forEach(System.out::println);
	}

	// sort by score, then equal scores by last name
	public void sortByScoreThenLast() {
		golfers.stream().sorted(Comparator.comparingInt(Golfer::getScore).thenComparing(Golfer::getLast))
				.forEach(System.out::println);
	}

	// sort by score, then by last, then by first
	public void sortByScoreThenLastThenFirst() {
		golfers.stream().sorted(Comparator.comparingInt(Golfer::getScore).thenComparing(Golfer::getLast)
				.thenComparing(Golfer::getFirst)).forEach(System.out::println);
	}

	public void partitionByScore() {
		Map<Boolean, List<Golfer>> map = golfers.stream()
				.collect(Collectors.partitioningBy(golfer -> golfer.getScore() < 70));

		map.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(System.out::println);
		});
	}
}
class Golfer implements Comparable<Golfer> {
    private String first;
    private String last;
    private int score;

    public Golfer() {}

    public Golfer(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Golfer(String first, String last, int score) {
        this.first = first;
        this.last = last;
        this.score = score;
    }

    @Override
    public int compareTo(Golfer golfer) {
        return score - golfer.score;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Golfer golfer = (Golfer) o;

        if (first != null ? !first.equals(golfer.first) : golfer.first != null) return false;
        return last != null ? last.equals(golfer.last) : golfer.last == null;

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Golfer{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", score=" + score +
                '}';
    }
}