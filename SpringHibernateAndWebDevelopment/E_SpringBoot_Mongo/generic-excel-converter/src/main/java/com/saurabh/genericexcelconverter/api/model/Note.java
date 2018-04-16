package com.saurabh.genericexcelconverter.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "noteList")
public class Note {
	@Id
	private String id;

	private LocalDateTime date;
	private String content;
	private String note;

	public Note(LocalDateTime date, String content) {
		this.date = date;
		this.content = content;
		this.note = null;
	}

	public Note(LocalDateTime date, String content, String note) {
		this(date, content);
		this.note = note;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Note note1 = (Note) o;

		if (!getDate().equals(note1.getDate())) return false;
		if (!getContent().equals(note1.getContent())) return false;
		return getNote() != null ? getNote().equals(note1.getNote()) : note1.getNote() == null;
	}

	@Override
	public int hashCode() {
		int result = getDate().hashCode();
		result = 31 * result + getContent().hashCode();
		result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Note{" +
				"date=" + date +
				", content='" + content + '\'' +
				", note='" + note + '\'' +
				'}';
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}

	public String getNote() {
		return note;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
