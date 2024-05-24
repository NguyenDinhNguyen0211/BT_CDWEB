package btgk.ltw.springboot.model;

import lombok.Data;

import java.util.Calendar;

@Data
public abstract class Entry {
	private String title;
	private String content;
	private Calendar createdTime;
	private User creator;

	public Entry(String title, String content, User creator) {
		this.title = title;
		this.content = content;
		this.creator = creator;
		createdTime = Calendar.getInstance();
	}
}
