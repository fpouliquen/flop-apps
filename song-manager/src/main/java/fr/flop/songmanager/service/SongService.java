package fr.flop.songmanager.service;

import java.util.List;

import fr.flop.songmanager.dto.SongDto;
import fr.flop.songmanager.util.exception.ClientException;

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
	 * @throws ScoresClientException
	 */
	List<SongDto> search(SongDto songDto) throws ClientException;

	/**
	 * Creates the song associated to the given dto object.
	 * 
	 * @param songDto
	 *            The song dto which contains the song data.
	 * @throws ClientException
	 */
	void create(SongDto songDto) throws ClientException;
}
