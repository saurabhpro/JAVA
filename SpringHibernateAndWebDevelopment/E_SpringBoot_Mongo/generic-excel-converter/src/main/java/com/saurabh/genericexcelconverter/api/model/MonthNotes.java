package com.saurabh.genericexcelconverter.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.saurabh.genericexcelconverter.web.dto.NoteDTO;

import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MonthNotes {

	@NotNull
	@JsonProperty("month")
	private final Month month;

	@NotNull
	@JsonProperty("noteList")
	private final List<NoteDTO> noteList;

	public MonthNotes(Month month, List<NoteDTO> noteList) {
		this.month = month;
		this.noteList = noteList;
	}

	public Month getMonth() {
		return month;
	}

	public List<NoteDTO> getNoteList() {
		return noteList;
	}
}
