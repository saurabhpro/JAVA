package springmvc.todotask.model;

import java.util.Date;

/**
 * Created by saurabhkumar on 03/09/17.
 */
public class TodoTask {
	private int id;
	private String user;
	private String desc;
	private Date targetDate;
	private boolean isDone;

	public TodoTask() {
	}

	public TodoTask(int id, String user, String desc, Date targetDate, boolean isDone) {
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TodoTask todoTask = (TodoTask) o;

		return getId() == todoTask.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getId();
		return result;
	}

	@Override
	public String toString() {
		return "TodoTask{" +
				"id=" + id +
				", user='" + user + '\'' +
				", desc='" + desc + '\'' +
				", targetDate=" + targetDate +
				", isDone=" + isDone +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean done) {

		isDone = done;
	}

}
