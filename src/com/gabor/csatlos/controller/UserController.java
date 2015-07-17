package com.gabor.csatlos.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabor.csatlos.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public Map<String, Object> register(@RequestBody User user) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Map<String, Object> update(@RequestBody User user) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Map<String, Object> get(@RequestBody User user) {
		
		return null;
	}
	
}
