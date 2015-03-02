
package org.flop.fsm.repository;

import java.util.List;

import org.flop.fsm.domain.Song;

public interface CustomSongRepository {

	/**
	 * Retrieves the songs associated to the given parameters. The search is not case
	 * sensitive and null values are ignored. The songs collection is simply returned
	 * when all the given values are null.
	 * 
	 * @param title
	 * @param author
	 * @return
	 */
	public List<Song> findByTitleAndAuthor(String title, String author);
}
