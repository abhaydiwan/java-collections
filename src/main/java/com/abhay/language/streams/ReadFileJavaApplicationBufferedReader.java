package com.abhay.language.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReadFileJavaApplicationBufferedReader {

	public static void main(String[] args) {
		try {

			File f = new File(Common.getPathToTargetFile(args));

			try (BufferedReader b = new BufferedReader(new FileReader(f))) {

				String readLine = "";

				// get total line count
				Instant lineCountStart = Instant.now();
				int lines = 0;

				Instant namesStart = Instant.now();
				ArrayList<String> names = new ArrayList<>();

				// get the 432nd and 43243 names
				ArrayList<Integer> indexes = new ArrayList<>();

				indexes.add(1);
				indexes.add(433);
				indexes.add(43244);

				// count the number of donations by month
				Instant donationsStart = Instant.now();
				ArrayList<String> dates = new ArrayList<>();

				// count the occurrences of first name
				Instant commonNameStart = Instant.now();
				ArrayList<String> firstNames = new ArrayList<>();


				System.out.println("Reading file using Buffered Reader");

				while ((readLine = b.readLine()) != null) {
					lines++;
					// System.out.println(readLine);

					// get all the names
					String array1[] = readLine.split("\\s*\\|\\s*");
					String name = array1[7];
					names.add(name);
					if(indexes.contains(lines)){
						System.out.println("Name: " + names.get(lines - 1) + " at index: " + (lines - 1));
					}

					if(name.contains(", ")) {

						String array2[] = (name.split(", "));
						String firstHalfOfName = array2[1].trim();

						if (!firstHalfOfName.isEmpty()) {
							if (firstHalfOfName.contains(" ")) {
								String array3[] = firstHalfOfName.split(" ");
								String firstName = array3[0].trim();
								firstNames.add(firstName);
							} else {
								firstNames.add(firstHalfOfName);
							}
						}
					}

					String rawDate = array1[4];
					String month = rawDate.substring(4,6);
					String year = rawDate.substring(0,4);
					String formattedDate = month + "-" + year;
					dates.add(formattedDate);

				}

				Instant namesEnd = Instant.now();
				long timeElapsedNames = Duration.between(namesStart, namesEnd).toMillis();
				System.out.println("Name time: " + timeElapsedNames + "ms");

				System.out.println("Total file line count: " + lines);
				Instant lineCountEnd = Instant.now();
				long timeElapsedLineCount = Duration.between(lineCountStart, lineCountEnd).toMillis();
				System.out.println("Line count time: " + timeElapsedLineCount + "ms");

				//HashMap<String, Integer> dateMap = new HashMap<>();
				dates.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((k,v)->System.out.println("Donations per month and year: "+k + " and donation count: " +v));
				// this can be simplify
				/*
				 * for(String date:dates) { dateMap.merge(date, 1, Integer::sum); }
				 */
				
				
				//freqWithoutStream.merge(s, 1L, Long::sum);
				/*
				 * for(String date:dates){ Integer count = dateMap.get(date); if (count == null)
				 * { dateMap.put(date, 1); } else { dateMap.put(date, count + 1); } }
				 */
				/*
				 * for (Map.Entry<String, Long> entry : dateMap.entrySet()) { String key =
				 * entry.getKey(); Long value = entry.getValue();
				 * System.out.println("Donations per month and year: " + key +
				 * " and donation count: " + value);
				 * 
				 * }
				 */				Instant donationsEnd = Instant.now();
				long timeElapsedDonations = Duration.between(donationsStart, donationsEnd).toMillis();
				System.out.println("Donations time: " + timeElapsedDonations + "ms");

				HashMap<String, Integer> map = new HashMap<>();
				
				/*
				 * for(String name:firstNames){ Integer count = map.get(name); if (count ==
				 * null) { map.put(name, 1); } else { map.put(name, count + 1); } }
				 */
                     //ItemToPrice.entrySet()
					/*
					 * .stream() .sorted(Map.Entry.<String, Integer>comparingByValue())
					 * .forEach(System.out::println);
					 */
				Map<String, Long> namesWithCount = firstNames.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				namesWithCount.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).forEach(System.out::println);
				
				LinkedList<Entry<String, Long>> list = new LinkedList<>(namesWithCount.entrySet());

				Collections.sort(list, new Comparator<Map.Entry<String, Long> >() {
					public int compare(Map.Entry<String, Long> o1,
					                   Map.Entry<String, Long> o2)
					{
						//comparing values....
						return (o2.getValue()).compareTo(o1.getValue());
					}
				});
				
				System.out.println("The most common first name is: " + list.get(0).getKey() + " and it occurs: " + list.get(0).getValue() + " times.");
				Instant commonNameEnd = Instant.now();
				long timeElapsedCommonName = Duration.between(commonNameStart, commonNameEnd).toMillis();
				System.out.println("Most common name time: " + timeElapsedCommonName + "ms");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}