
package org.flop.wtm.dto;

public class ScoreDto {

	private String title;

	private String author;

	private String key;

	public ScoreDto(String title, String author, String key) {
		this.title = title;
		this.author = author;
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getKey() {
		return key;
	}

}
