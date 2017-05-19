package fr.flop.songmanager.business;

import fr.flop.songmanager.dao.entity.SongWriter;

public interface SongWriterBusiness {

	/**
	 * Creates the song writer with the given parameters.
	 * 
	 * @param firstName
	 *            The first name of the song writer.
	 * @param lastName
	 *            The last name of the song writer.
	 * @return The created song writer.
	 */
	SongWriter create(String firstName, String lastName);

	/**
	 * Retrieves the song writer associated to the given id.
	 * 
	 * @param songWriterId
	 *            The id of the wanted song writer.
	 * @return The song writer associated to the given id.
	 */
	SongWriter findBy(Integer songWriterId);

	/**
	 * Removes the given song writer.
	 * 
	 * @param songWriter
	 *            The song writer to remove.
	 */
	void delete(SongWriter songWriter);
}
