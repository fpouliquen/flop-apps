package fr.flop.songmanager.service;

import fr.flop.songmanager.dto.SongWriterDto;
import fr.flop.songmanager.util.exception.ServerException;

public interface SongWriterService {

	/**
	 * Creates the song writer associated to the given dto data.
	 * 
	 * @param songWriterDto
	 *            The dto object which contains the song writer data.
	 * @throws ServerException
	 */
	void create(SongWriterDto songWriterDto) throws ServerException;

	/**
	 * Removes the song writer associated with the given id.
	 * 
	 * @param songWriterId
	 *            The song writer id.
	 * @throws ServerException
	 */
	void delete(Integer songWriterId) throws ServerException;
}
