
package org.flop.fsm.dto;

public class SongDto {

	private String title;

	private String author;

	public SongDto(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
}
