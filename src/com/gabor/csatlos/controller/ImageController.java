package com.gabor.csatlos.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.utils.ResponseBuilder;

@Controller
@RequestMapping("/image")
public class ImageController {

	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public Map<String, Object> upload() {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Map<String, Object> get(@RequestParam String id) {
		
		return null;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> handleBadRequest() {
		return ResponseBuilder.sendError(ErrorStatus.INVALID_PARAMETER);
	}
}
