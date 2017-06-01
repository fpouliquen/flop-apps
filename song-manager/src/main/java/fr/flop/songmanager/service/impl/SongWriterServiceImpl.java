package fr.flop.songmanager.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.flop.songmanager.dao.entity.SongWriter;
import fr.flop.songmanager.dao.repository.SongWriterRepository;
import fr.flop.songmanager.dto.SongWriterDto;
import fr.flop.songmanager.service.SongWriterService;
import fr.flop.songmanager.util.exception.ServerException;
import fr.flop.songmanager.util.log.ELogFunction;
import fr.flop.songmanager.util.log.LogUtils;

@Component
@Transactional(readOnly = true)
public class SongWriterServiceImpl implements SongWriterService {

	private static final Logger LOGGER = Logger.getLogger(SongWriterServiceImpl.class);

	@Autowired
	private SongWriterRepository songWriterRepository;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	@Override
	@Transactional(readOnly = false)
	public void create(SongWriterDto songWriterDto) throws ServerException {
		// Checks if the wanted song writer already exists
		SongWriter songWriter = songWriterRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(
				songWriterDto.getFirstName(), songWriterDto.getLastName());

		if (songWriter == null) {
			songWriter = new SongWriter(songWriterDto.getFirstName(), songWriterDto.getLastName());
		} else {
			throw new ServerException("A song writer " + songWriterDto.getFirstName() + " "
					+ songWriterDto.getLastName() + " already exists !");
		}

		// Creates the wanted song writer
		songWriter = songWriterRepository.save(songWriter);
		LOGGER.info(LogUtils.getLog(songWriter, ELogFunction.SONG_WRITER_SERVICE, "The song writer has been created."));
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer songWriterId) throws ServerException {

	}
}
