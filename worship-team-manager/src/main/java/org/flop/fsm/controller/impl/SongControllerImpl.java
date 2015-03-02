
package org.flop.fsm.controller.impl;

import org.flop.fsm.controller.SongController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("song")
public class SongControllerImpl implements SongController {

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public String display() {
		return "song";
	}

	@Override
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "author", required = false) String author, Model model) {

		// here is the code to search for the corresponding songs

		return "song";
	}

}
