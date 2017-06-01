package fr.flop.songmanager.service;

import java.util.List;

import fr.flop.songmanager.dto.SongDto;
import fr.flop.songmanager.util.exception.ServerException;

/**
 *
 */
public interface SongService {

	/**
	 * Retrieves the songs associated with the given dto data.
	 * 
	 * @param songDto
	 *            The dto object which contains the data of the search?
	 * @return The songs associated with the given search data.
	 * @throws ServerException
	 */
	List<SongDto> search(SongDto songDto) throws ServerException;

	/**
	 * Creates the song associated to the given dto object. If a song with the
	 * given data already exists, an exception is thrown.
	 * 
	 * @param songDto
	 *            The song dto which contains the song data.
	 * @return The id of the created song.
	 * @throws ServerException
	 */
	Integer create(SongDto songDto) throws ServerException;

	/**
	 * Updates the song associated to the given id with the given data.
	 * 
	 * @param id
	 *            The id of the song to update.
	 * @param songDto
	 *            The update data.
	 */
	void update(Integer id, SongDto songDto) throws ServerException;
}
