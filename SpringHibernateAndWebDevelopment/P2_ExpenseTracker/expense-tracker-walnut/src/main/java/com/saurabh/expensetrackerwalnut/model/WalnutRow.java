package com.saurabh.expensetrackerwalnut.model;

import com.saurabh.expensetrackerwalnut.model.helper_enums.Category;
import com.saurabh.expensetrackerwalnut.model.helper_enums.Mode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class WalnutRow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	private LocalDateTime dateTime;

	@NotBlank
	@Size(max = 255)
	private String place;

	@Column(precision = 8, scale = 2)
	private float amount;

	private Mode modeOfExpense;

	private boolean isExpense;

	private Category category;

	@Column
	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	//without EAGER, tags cant be loaded lazily
	private List<String> tags;

	private String note;

	private LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	private int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		DecimalFormat df = new DecimalFormat("#.##");
		this.amount = Float.parseFloat(df.format(amount));
	}

	public Mode getModeOfExpense() {
		return modeOfExpense;
	}

	public void setModeOfExpense(Mode modeOfExpense) {
		this.modeOfExpense = modeOfExpense;
	}

	public boolean isExpense() {
		return isExpense;
	}

	public void setExpense(boolean expense) {
		isExpense = expense;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "WalnutRow{" +
				"ID=" + ID +
				", dateTime=" + dateTime +
				", place='" + place + '\'' +
				", amount=" + amount +
				", modeOfExpense=" + modeOfExpense +
				", isExpense=" + isExpense +
				", category=" + category +
				", tags=" + tags +
				", note='" + note + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		WalnutRow walnutRow = (WalnutRow) o;

		return getID() == walnutRow.getID() && getDateTime().equals(walnutRow.getDateTime());
	}

	@Override
	public int hashCode() {
		int result = getID();
		result = 31 * result + getDateTime().hashCode();
		return result;
	}
}
