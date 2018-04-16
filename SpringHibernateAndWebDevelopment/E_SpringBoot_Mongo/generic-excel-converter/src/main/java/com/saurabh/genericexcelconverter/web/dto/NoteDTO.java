package com.saurabh.genericexcelconverter.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * This class will hold the justice league memger details that will be received
 * as a json input from web.
 *
 * @author dinuka
 */
@JsonInclude(value = Include.NON_NULL)
public class NoteDTO {

	@NotNull
	@JsonProperty("content")
	private String content;

	@NotNull
	@JsonProperty("date")
	private String date;

	@JsonProperty("comment")
	private String comment;

	public NoteDTO(@JsonProperty("date") String date,
	               @JsonProperty("content") String content,
	               @JsonProperty("comment") String comment) {
		this.content = content;
		this.date = date;
		this.comment = comment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
