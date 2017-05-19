package fr.flop.songmanager.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.flop.songmanager.business.SongWriterBusiness;
import fr.flop.songmanager.dao.entity.SongWriter;
import fr.flop.songmanager.dao.repository.SongWriterRepository;
import fr.flop.songmanager.util.exception.ServerException;

@Component
public class SongWriterBusinessImpl implements SongWriterBusiness {

	@Autowired
	private SongWriterRepository songWriterRepository;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	@Override
	public SongWriter create(String firstName, String lastName) {
		SongWriter songWriter = songWriterRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName,
				lastName);

		if (songWriter == null) {
			songWriter = new SongWriter(firstName, lastName);
		} else {
			throw new ServerException("A song writer " + firstName + " " + lastName + " already exists !");
		}

		return songWriterRepository.save(songWriter);
	}

	@Override
	public SongWriter findBy(Integer songWriterId) {
		return songWriterRepository.findOne(songWriterId);
	}

	@Override
	public void delete(SongWriter songWriter) {
		songWriterRepository.delete(songWriter);
	}
}
