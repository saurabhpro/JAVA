package com.saurabh.basicannotate;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "basics_udemy_annotation/src/main/resources/fortune-data.txt";
	private List<String> theFortunes;

	// create a random number generator
	private Random myRandom = new Random();

	public FileFortuneService() {
		System.out.println(">> FileFortuneService: inside default constructor");
	}

	@PostConstruct
	private void loadTheFortunesFile() {

		System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");

		File theFile = new File(fileName);

		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());

		// initialize array list
		theFortunes = new ArrayList<String>();

		// read fortunes from file
		try (BufferedReader br = new BufferedReader(
				new FileReader(theFile))) {

			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}

		} catch (IOException e) {
			System.out.println("Please check that file exists on " + fileName);
			e.printStackTrace();
		}
	}

	@Override
	public String getDailyFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(theFortunes.size());

		return theFortunes.get(index);
	}

}
