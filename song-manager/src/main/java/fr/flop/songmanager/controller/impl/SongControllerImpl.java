package fr.flop.songmanager.controller.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fr.flop.songmanager.controller.SongController;
import fr.flop.songmanager.dto.SongDto;
import fr.flop.songmanager.service.SongService;
import fr.flop.songmanager.util.exception.CustomErrorType;
import fr.flop.songmanager.util.exception.ServerException;

@RestController
@RequestMapping("/api")
public class SongControllerImpl implements SongController {

	private static final Logger LOGGER = Logger.getLogger(SongControllerImpl.class);

	@Autowired
	private SongService songService;

	@Override
	@RequestMapping(value = "/song/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody SongDto songDto, UriComponentsBuilder ucBuilder) {
		Integer createdSongDtoId = null;
		try {
			createdSongDtoId = songService.create(songDto);
		} catch (ServerException e) {
			return new ResponseEntity(new CustomErrorType(e.getMessage()), HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/song/{id}").buildAndExpand(createdSongDtoId).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/song/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody SongDto songDto) {
		try {
			songService.update(id, songDto);
		} catch (ServerException e) {
			return new ResponseEntity(new CustomErrorType(e.getMessage()), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<SongDto>(songDto, HttpStatus.OK);
	}
}
