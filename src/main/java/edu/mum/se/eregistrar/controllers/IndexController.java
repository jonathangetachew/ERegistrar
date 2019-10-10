package edu.mum.se.eregistrar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jonathan on 10/8/2019.
 */

@Controller
public class IndexController {

	@RequestMapping(value = {"", "/", "/eregistrar", "/eregistrar/home"},
					method = RequestMethod.GET)
	public String index() {
		return "index";
	}

}
