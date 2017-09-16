package com.saurabh.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by saurabhkumar on 05/04/17.
 */
public class Student {
	private HashMap<String, String> countryOptions;
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private HashMap<String, String> favoriteLanguageOptions;
	private List<String> operatingSystems = new ArrayList<>();

	public Student() {
		countryOptions = new HashMap<>();

		countryOptions.put("IND", "India");
		countryOptions.put("BRA", "Brazil");
		countryOptions.put("GER", "Germany");
		countryOptions.put("USA", "USAmerica");
		countryOptions.put("SRK", "SaaRK");


		// populate favorite language options
		favoriteLanguageOptions = new HashMap<>();

		// parameter order: value, display label
		//
		favoriteLanguageOptions.put("Java", "Java");
		favoriteLanguageOptions.put("C#", "C#");
		favoriteLanguageOptions.put("PHP", "PHP");
		favoriteLanguageOptions.put("Ruby", "Ruby");

	}

	public HashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public HashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public List<String> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(List<String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
}
