package com.gabor.csatlos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/movie")
public class MovieController {

 
	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("movie", name);
 
		//return to jsp page, configured in mvc-dispatcher-servlet.xml, view resolver
		return "list";
 
	}
 
}
