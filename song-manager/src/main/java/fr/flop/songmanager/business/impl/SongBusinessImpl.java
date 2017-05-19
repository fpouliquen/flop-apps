package fr.flop.songmanager.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.flop.songmanager.business.SongBusiness;
import fr.flop.songmanager.dao.entity.Song;
import fr.flop.songmanager.dao.repository.SongRepository;
import fr.flop.songmanager.dao.repository.SongWriterRepository;
import fr.flop.songmanager.util.exception.ServerException;

@Component
public class SongBusinessImpl implements SongBusiness {

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
	public Song create(String title, List<Integer> songWriterIds) {
		Song song = findBy(title, songWriterIds);

		if (song == null) {
			song = new Song(title, songWriterRepository.findByIdIn(songWriterIds));
		} else {
			throw new ServerException("A song " + title + " associated with the given song writer(s) already exists !");
		}

		return songRepository.save(song);
	}

	@Override
	public Song findBy(String title, List<Integer> songWriterIds) {
		return songRepository.findByTitleIgnoreCaseAndSongSongWritersSongWriterIdIn(title, songWriterIds);
	}
}