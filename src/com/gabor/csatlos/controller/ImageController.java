package com.gabor.csatlos.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/image")
public class ImageController {

	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public Map<String, Object> register() {
		
		return null;
	}
}
