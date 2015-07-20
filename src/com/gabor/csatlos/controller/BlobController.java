package com.gabor.csatlos.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.service.BlobService;
import com.gabor.csatlos.utils.ResponseBuilder;

@Controller
@RequestMapping("/blob")
public class BlobController {

	@Autowired
	private BlobService blobService;
	
	@ResponseBody
	@RequestMapping(value = "/uploadUrl", method = RequestMethod.GET)
	public Map<String, Object> uploadUrl() {
		return blobService.generateUploadUrl("/blob/upload");
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload")
	public Map<String, Object> upload(HttpServletRequest request) {
		return blobService.upload(request);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> handleBadRequest() {
		return ResponseBuilder.sendError(ErrorStatus.INVALID_PARAMETER);
	}
}
