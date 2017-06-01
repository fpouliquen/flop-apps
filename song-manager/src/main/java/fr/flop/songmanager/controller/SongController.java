package fr.flop.songmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import fr.flop.songmanager.dto.SongDto;

public interface SongController {

	/**
	 * Creates the song associated to the given data.
	 * 
	 * @param songDto
	 *            The song data used to create the song.
	 * @param ucBuilder
	 *            Uri builder
	 * @return The http response.
	 */
	ResponseEntity<?> create(SongDto songDto, UriComponentsBuilder ucBuilder);

}
