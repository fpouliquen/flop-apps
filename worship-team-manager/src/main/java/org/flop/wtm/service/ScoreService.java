
package org.flop.wtm.service;

import java.util.List;

import org.flop.wtm.dto.ScoreDto;

public interface ScoreService {

	/**
	 * Retrieves the scores according to the given parameters.
	 * 
	 * @param title
	 * @param author
	 * @param key
	 * @return The retrieved scores.
	 */
	public List<ScoreDto> search(String title, String author, String key);

}