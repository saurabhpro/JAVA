package com.saurabh.model;

import javax.validation.constraints.*;

/**
 * Created by saurabhkumar on 06/04/17.
 */
public class Customer {
	private String firstName;

	@NotNull(
			message = "is Required"
	)   //this message will override any validator message
	@Size(
			min = 1,
			message = "is Required"
	) //this means 1 entry must
	private String lastName;

	@NotNull(
			message = "is required integer"
	) //only handles the not null for this field
	@Min(
			value = 1,
			message = "Must be greater than 0"
	)
	@Max(
			value = 10,
			message = "Must be smaller than 10"
	)
	//if return type is premitive int, @NotNull can be applied OBiously, so use Integer
	//but if its integer - the input field would be 0 be default... not so the case with integer
	private Integer freePasses;

	@Pattern(
			regexp = "^[a-zA-Z0-9]{5}",
			message = "only 5 characters allowed"
	)
	private String postalCode;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
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
}
