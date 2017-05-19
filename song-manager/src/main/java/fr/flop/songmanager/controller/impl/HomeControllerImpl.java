
package fr.flop.songmanager.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.flop.songmanager.controller.HomeController;

@Controller
@RequestMapping("/")
public class HomeControllerImpl implements HomeController {

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public String displayHomePage() {
		return "index";
	}
}
