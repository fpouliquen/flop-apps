
package org.flop.wtm.repository;

import java.util.List;

import org.flop.wtm.domain.Score;

public interface CustomScoreRepository {

	/**
	 * Retrieves the scores associated to the given parameters. The search is not case
	 * sensitive and null values are ignored. The scores collection is simply returned
	 * when all the given values are null.
	 * 
	 * @param title
	 * @param author
	 * @param key
	 * @return
	 */
	public List<Score> findByTitleAndAuthorAndKey(String title, String author, String key);
}
