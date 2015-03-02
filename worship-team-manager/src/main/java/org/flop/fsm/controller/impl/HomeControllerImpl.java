
package org.flop.fsm.controller.impl;

import org.flop.fsm.controller.HomeController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeControllerImpl implements HomeController {

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public String display() {
		return "index";
	}
}