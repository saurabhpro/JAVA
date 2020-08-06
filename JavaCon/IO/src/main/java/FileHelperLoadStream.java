/*
 * Copyright (c) 2019 Saurabh Kumar
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

public class FileHelperLoadStream {

	public static void main(String[] args) {

		FileHelperLoadStream obj = new FileHelperLoadStream();
		// non static
		System.out.println(obj.getFilePathToSave());

		// static
		System.out.println(FileHelperLoadStream.getFilePathToSaveStatic());
	}

	public static String getFilePathToSaveStatic() {
		Properties prop = new Properties();
		String result = "";

		try (InputStream inputStream = FileHelperLoadStream.class.getClassLoader().getResourceAsStream("config.properties")) {

			prop.load(inputStream);
			result = prop.getProperty("json.filepath");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}

	public String getFilePathToSave() {
		Properties prop = new Properties();

		String result = "";

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
			prop.load(inputStream);
			result = prop.getProperty("json.filepath");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}