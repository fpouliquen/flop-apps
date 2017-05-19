package fr.flop.songmanager.service;

import fr.flop.songmanager.dto.SongWriterDto;
import fr.flop.songmanager.util.exception.ClientException;

public interface SongWriterService {

	/**
	 * Creates the song writer associated to the given dto data.
	 * 
	 * @param songWriterDto
	 *            The dto object which contains the song writer data.
	 * @throws ClientException
	 */
	void create(SongWriterDto songWriterDto) throws ClientException;

	/**
	 * Removes the song writer associated with the given id.
	 * 
	 * @param songWriterId
	 *            The song writer id.
	 * @throws ClientException
	 */
	void delete(Integer songWriterId) throws ClientException;
}
