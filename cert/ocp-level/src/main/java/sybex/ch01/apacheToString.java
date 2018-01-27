package sybex.ch01;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Once you’ve written a toString() method, it starts to get boring to write more—especially
 * if you want to include a lot of instance variables
 */
public class apacheToString {

	private int id;
	private String name;

	private apacheToString(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static void main(String[] args) {
		apacheToString ob = new apacheToString(5, "sk");
		System.out.println(ob);
	}

	@Override
	public boolean equals(Object o) {

		// if all variables used
		// return EqualsBuilder.reflectionEquals(this, obj);

		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		apacheToString that = (apacheToString) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.isEquals();
	}

	/* easy way with prime multiplier
	public int hashCode() {
return keyField + 7 * otherKeyField.hashCode();
}
	 */

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(name)
				.toHashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
