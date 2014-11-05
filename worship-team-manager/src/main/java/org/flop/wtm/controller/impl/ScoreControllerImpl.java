
package org.flop.wtm.controller.impl;

import org.flop.wtm.controller.ScoreController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("score")
public class ScoreControllerImpl implements ScoreController {

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public String display() {
		return "score";
	}

	@Override
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "author", required = false) String author,
			@RequestParam(value = "key", required = false) String key, Model model) {

		// here is the code to search for the corresponding scores

		return "score";
	}

}
