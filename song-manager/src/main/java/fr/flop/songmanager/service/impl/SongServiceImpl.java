package fr.flop.songmanager.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.flop.songmanager.dao.entity.Song;
import fr.flop.songmanager.dao.entity.SongSongWriter;
import fr.flop.songmanager.dao.entity.SongWriter;
import fr.flop.songmanager.dao.repository.SongRepository;
import fr.flop.songmanager.dao.repository.SongWriterRepository;
import fr.flop.songmanager.dto.SongDto;
import fr.flop.songmanager.service.SongService;
import fr.flop.songmanager.util.exception.ServerException;
import fr.flop.songmanager.util.log.ELogFunction;
import fr.flop.songmanager.util.log.LogUtils;

@Component
@Transactional(readOnly = true)
public class SongServiceImpl implements SongService {

	private static final Logger LOGGER = Logger.getLogger(SongServiceImpl.class);

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private SongWriterRepository songWriterRepository;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	@Override
	public List<SongDto> search(SongDto songDto) {
		songRepository.findByTitleIgnoreCaseAndSongSongWritersSongWriterIdIn(songDto.getTitle(),
				songDto.getSongWriterIds());

		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public Integer create(SongDto songDto) {
		// Checks if the wanted song already exists
		Song song = songRepository.findByTitleIgnoreCaseAndSongSongWritersSongWriterIdIn(songDto.getTitle(),
				songDto.getSongWriterIds());

		if (song == null) {
			song = new Song(songDto.getTitle(), songWriterRepository.findByIdIn(songDto.getSongWriterIds()));
		} else {
			throw new ServerException(
					"A song " + songDto.getTitle() + " associated with the given song writer(s) already exists !");
		}

		// Creates the wanted song
		song = songRepository.save(song);
		LOGGER.info(LogUtils.getLog(song, ELogFunction.SONG_SERVICE, "The song has been created."));

		return song.getId();
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Integer id, SongDto songDto) {
		Song song = songRepository.findOne(id);

		if (song == null) {
			throw new ServerException("The song " + songDto.getTitle() + " does not exist !");
		}

		song.setTitle(songDto.getTitle());

		// Removes the existing associations with song writers
		song.getSongSongWriters().forEach(songSongWriter -> {
			songSongWriter.getSong().getSongSongWriters().remove(songSongWriter);
			songSongWriter.getSongWriter().getSongSongWriters().remove(songSongWriter);
		});

		// Creates the wanted associations with song writers
		songDto.getSongWriterIds().forEach(songWriterId -> {
			SongWriter songWriter = songWriterRepository.findOne(songWriterId);
			if (songWriter != null) {
				new SongSongWriter(song, songWriter);
			}
		});
	}

	/**
	 * Converts the given song to a song dto object.
	 * 
	 * @param song
	 *            The song to convert.
	 * @return The created dto from the given song.
	 */
	private SongDto songToSongDto(Song song) {
		SongDto songDto = new SongDto();
		songDto.setTitle(song.getTitle());
		song.getSongSongWriters()
				.forEach(songSongWriter -> songDto.getSongWriterIds().add(songSongWriter.getSongWriter().getId()));
		return songDto;
	}
}
