
package org.flop.wtm.controller.impl;

import org.flop.wtm.controller.SearchController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchControllerImpl implements SearchController {

	@Override
	@RequestMapping("/search")
	public String search(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "author", required = false) String author,
			@RequestParam(value = "key", required = false) String key, Model model) {

		// here is the code to search for the corresponding scores

		return "search";
	}
}
