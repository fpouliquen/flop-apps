
package org.flop.wtm.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scores")
@TypeAlias("score")
public class Score extends AbstractDocument {

	private String title;

	private String author;

	private String key;

	public Score() {
	}

	public Score(String title, String author, String key) {
		this.author = author;
		this.key = key;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Score [title=" + title + ", author=" + author + ", key=" + key + "]";
	}

}
