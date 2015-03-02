
package org.flop.fsm.service.impl;

import java.util.List;

import org.flop.fsm.domain.Song;
import org.flop.fsm.dto.SongDto;
import org.flop.fsm.repository.SongRepository;
import org.flop.fsm.service.MappingService;
import org.flop.fsm.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {

	private SongRepository songRepository;

	private MappingService mappingService;

	@Autowired
	public SongServiceImpl(SongRepository songRepository, MappingService mappingService) {
		this.songRepository = songRepository;
		this.mappingService = mappingService;
	}

	@Override
	public List<SongDto> search(String title, String author) {
		List<Song> retrievedSongs = songRepository.findByTitleAndAuthor(title, author);
		return mappingService.map(retrievedSongs, SongDto.class);
	}
}
