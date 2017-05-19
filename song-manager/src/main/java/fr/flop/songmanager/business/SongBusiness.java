package fr.flop.songmanager.business;

import java.util.List;

import fr.flop.songmanager.dao.entity.Song;

public interface SongBusiness {

	/**
	 * Creates a song associated to the given parameters.
	 * 
	 * @param title
	 *            The title of the song
	 * @param songWriterIds
	 *            The song writer ids with which the song must be associated.
	 * @return The created song.
	 */
	Song create(String title, List<Integer> songWriterIds);

	/**
	 * Retrieves the song associated with the given parameters.
	 * 
	 * @param title
	 *            The title of the wanted song.
	 * @param songWriterIds
	 *            The song writer ids associated with the wanted song.
	 * @return The song associated with the given parameters.
	 */
	Song findBy(String title, List<Integer> songWriterIds);
}
