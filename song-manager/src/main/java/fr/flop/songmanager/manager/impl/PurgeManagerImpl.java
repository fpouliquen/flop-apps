package fr.flop.songmanager.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.flop.songmanager.dao.entity.SongWriter;
import fr.flop.songmanager.dao.repository.SongWriterRepository;
import fr.flop.songmanager.manager.PurgeManager;
import fr.flop.songmanager.util.exception.ServerException;

public class PurgeManagerImpl implements PurgeManager {

	@Autowired
	private SongWriterRepository songWriterRepository;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public void purgeSong(Integer songId) {

	}

	@Override
	public void purgeSongWriter(Integer songWriterId) {
		SongWriter songWriter = songWriterRepository.findOne(songWriterId);

		if (songWriter == null) {
			throw new ServerException("The song writer to remove does not exist !");
		} else {
			// Removes the song writer from the associated songs
			songWriter.getSongSongWriters().forEach(songSongWriter -> {
				songSongWriter.getSong().getSongSongWriters().remove(songSongWriter);
			});

			songWriterRepository.delete(songWriter);
		}
	}
}
