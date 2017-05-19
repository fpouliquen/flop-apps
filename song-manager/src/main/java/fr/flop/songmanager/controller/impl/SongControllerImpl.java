package fr.flop.songmanager.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.flop.songmanager.controller.SongController;
import fr.flop.songmanager.dto.SongDto;

@RestController
public class SongControllerImpl implements SongController {

	@Override
	@RequestMapping("/song")
	public SongDto getSong() {
		SongDto songDto = new SongDto();
		songDto.setTitle("test");
		songDto.setSongId(1);
		return songDto;
	}
}
