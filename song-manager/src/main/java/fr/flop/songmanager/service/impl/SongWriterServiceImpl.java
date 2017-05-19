package fr.flop.songmanager.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.flop.songmanager.business.SongWriterBusiness;
import fr.flop.songmanager.dao.entity.SongWriter;
import fr.flop.songmanager.dto.SongWriterDto;
import fr.flop.songmanager.service.SongWriterService;
import fr.flop.songmanager.util.exception.ClientException;
import fr.flop.songmanager.util.log.ELogFunction;
import fr.flop.songmanager.util.log.LogUtils;

@Component
@Transactional(readOnly = true)
public class SongWriterServiceImpl implements SongWriterService {

	private static final Logger LOGGER = Logger.getLogger(SongWriterServiceImpl.class);

	@Autowired
	private SongWriterBusiness songWriterBusiness;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	@Override
	@Transactional(readOnly = false)
	public void create(SongWriterDto songWriterDto) throws ClientException {
		// Creates the wanted song writer
		SongWriter songWriter = songWriterBusiness.create(songWriterDto.getFirstName(), songWriterDto.getLastName());

		LOGGER.info(LogUtils.getLog(songWriter, ELogFunction.SONG_WRITER_SERVICE, "The song writer has been created."));
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer songWriterId) throws ClientException {

	}
}
