package com.saurabh.genericexcelconverter.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * This class represents the output given out to the calling party as a json
 * representation.
 */
@JsonInclude(value = Include.NON_NULL)
public class ResponseDTO {

	@NotNull
	@JsonProperty("status")
	private Status status;

	@JsonProperty("message")
	private String message;

	public ResponseDTO(@JsonProperty("status") Status status, @JsonProperty("message") String message) {
		this.status = status;
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ResponseDTO that = (ResponseDTO) o;

		if (getStatus() != that.getStatus()) return false;
		return getMessage() != null ? getMessage().equals(that.getMessage()) : that.getMessage() == null;
	}

	@Override
	public int hashCode() {
		int result = getStatus() != null ? getStatus().hashCode() : 0;
		result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ResponseDTO{" +
				"status=" + status +
				", message='" + message + '\'' +
				'}';
	}

	public enum Status {
		SUCCESS, FAIL
	}
}
