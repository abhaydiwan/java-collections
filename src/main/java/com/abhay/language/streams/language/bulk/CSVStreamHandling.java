package com.abhay.language.streams.language.bulk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSVStreamHandling {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		var filePath = System.getProperty("user.dir") + "/src/main/resources/airquality.csv";
		var fileEntries = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null)
				fileEntries.add(line);

		}
		fileEntries.remove(0); // remove the csv header entry

		for (var entry : fileEntries) {
			if (entry.startsWith("India,Bihar")) {
				System.out.println(entry);
			}
		}

		/*
		 * It is low-level. Why should we care about BufferedReader, checking with null
		 * etc? Procedural. This is external looping, changing state, explicit
		 * conditional checks … Verbose. This is a small program, but still verbose for
		 * what it is doing. It doesn’t read like prose!
		 */

		System.out.println("###########################Stream way of filtering the data...###########################");
		Files.lines(Paths.get(filePath)).skip(0) // ignore the first entry
				.filter(line -> line.startsWith("India,Bihar")).forEach(System.out::println);

	}
}
