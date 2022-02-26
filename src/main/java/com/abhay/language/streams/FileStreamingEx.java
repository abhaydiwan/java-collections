package com.abhay.language.streams;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class FileStreamingEx {

	public static void main(String[] args) {

		// File f = new File("src/main/resources/test.txt");
		File f = new File(Common.getPathToTargetFile(args));

		try {
			// FileInputStream inputStream = new FileInputStream(f);
			// Scanner sc = new Scanner(inputStream, "UTF-8");
			LineIterator itr = FileUtils.lineIterator(f, "UTF-8");
			ArrayList<String> names = new ArrayList<>();
			// get the 432nd and 43243 names
			ArrayList<Integer> indexes = new ArrayList<>();
			indexes.add(436);
			indexes.add(2098);
			int lines = 0;
			// while (sc.hasNextLine()) {
			while (itr.hasNext()) {
				String line = itr.nextLine();
				// 1.Get the File’s Total Line Count
				lines++;
				String array1[] = line.split("\\s*\\|\\s*");
				String rawDate = array1[4];
				String month = rawDate.substring(4, 6);
				String year = rawDate.substring(0, 4);
				String formattedDate = month + "-" + year;
				// dates.add(formattedDate);
				System.out.println(array1[0]);
				String name = array1[7];
				names.add(name);
				if (indexes.contains(lines)) {
					System.out.println("Name: " + names.get(lines - 1) + " at  index: " + (lines - 1));
				}
				// do some more things ...
			}
			System.out.println(lines);
			// do some final things
		   } catch (Exception e) {
    	}
	}
}