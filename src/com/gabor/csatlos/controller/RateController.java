package com.gabor.csatlos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.service.RateService;
import com.gabor.csatlos.utils.ResponseBuilder;

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
		int rate;
		
		try {
			rate = Integer.parseInt(rateValue);
		} catch (Exception ex) {
			return ResponseBuilder.sendError(ErrorStatus.INVALID_PARAMETER_TYPE);
		}
		
		return rateService.set(id, rate);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> handleBadRequest() {
		return ResponseBuilder.sendError(ErrorStatus.INVALID_PARAMETER);
	}
}
