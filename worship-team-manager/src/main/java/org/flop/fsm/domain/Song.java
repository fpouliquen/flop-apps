
package org.flop.fsm.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
@TypeAlias("song")
public class Song extends AbstractDocument {

	private String title;

	private String author;

	public Song() {
	}

	public Song(String title, String author) {
		this.author = author;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", author=" + author + "]";
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
}
