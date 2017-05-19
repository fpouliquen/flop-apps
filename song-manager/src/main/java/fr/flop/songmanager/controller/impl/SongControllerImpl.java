package fr.flop.songmanager.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.flop.songmanager.controller.SongController;
import fr.flop.songmanager.dto.SongDto;

@RestController
public class SongControllerImpl implements SongController {

	@RequestMapping("/song")
	public SongDto greeting(@RequestParam(value = "title") String title) {
		return new SongDto();
	}
}
