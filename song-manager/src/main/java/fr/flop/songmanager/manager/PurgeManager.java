package fr.flop.songmanager.manager;

public interface PurgeManager {

	/**
	 * Delete the song writer associated with the given parameter. All the songs
	 * associated to the removed song writer are not purged.
	 * 
	 * @param songWriterId
	 */
	void purgeSongWriter(Integer songWriterId);

}
