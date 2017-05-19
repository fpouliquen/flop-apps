package fr.flop.songmanager.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.flop.songmanager.business.SongBusiness;
import fr.flop.songmanager.dao.entity.Song;
import fr.flop.songmanager.dto.SongDto;
import fr.flop.songmanager.service.SongService;
import fr.flop.songmanager.util.exception.ClientException;
import fr.flop.songmanager.util.log.ELogFunction;
import fr.flop.songmanager.util.log.LogUtils;

@Component
@Transactional(readOnly = true)
public class SongServiceImpl implements SongService {

	private static final Logger LOGGER = Logger.getLogger(SongServiceImpl.class);

	@Autowired
	private SongBusiness songBusiness;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	@Override
	public List<SongDto> search(SongDto songDto) throws ClientException {
		songBusiness.findBy(songDto.getTitle(), songDto.getSongWriterIds());

		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void create(SongDto songDto) throws ClientException {
		// Creates the wanted song
		Song song = songBusiness.create(songDto.getTitle(), songDto.getSongWriterIds());

		LOGGER.info(LogUtils.getLog(song, ELogFunction.SONG_SERVICE, "The song has been created."));
	}
}
