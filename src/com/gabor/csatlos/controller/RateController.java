package com.gabor.csatlos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabor.csatlos.service.RateService;

@Controller
@RequestMapping("/rate")
public class RateController {

	
	@Autowired
	private RateService rateService;
	
	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Map<String, Object> get() {
		
		return rateService.get();
	}
	
	@ResponseBody
	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public Map<String, Object> set(@RequestParam String id, 
								   @RequestParam String rateValue) {
		
		return null;
	}
}
