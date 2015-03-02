
package org.flop.fsm.service;

import java.util.List;

import org.flop.fsm.dto.SongDto;

public interface SongService {

	/**
	 * Retrieves the songs according to the given parameters.
	 * 
	 * @param title
	 * @param author
	 * @return The retrieved songs.
	 */
	public List<SongDto> search(String title, String author);

}