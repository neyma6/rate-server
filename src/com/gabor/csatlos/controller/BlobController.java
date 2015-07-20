package com.gabor.csatlos.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.domain.ResponseParam;
import com.gabor.csatlos.service.BlobService;
import com.gabor.csatlos.service.RateService;
import com.gabor.csatlos.utils.ResponseBuilder;

@Controller
@RequestMapping("/blob")
public class BlobController {

	private static final Logger LOGGER = Logger.getLogger(BlobController.class);
	
	@Autowired
	private BlobService blobService;
	
	@ResponseBody
	@RequestMapping(value = "/uploadUrl", method = RequestMethod.GET)
	public Map<String, Object> uploadUrl() {
		return blobService.generateUploadUrl("/blob/upload");
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Map<String, Object> upload(HttpServletRequest request) {
		return blobService.upload(request);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> handleBadRequest(Exception ex) {
		LOGGER.error("BlobController/handleBadRequest", ex);
		return ResponseBuilder.sendError(ErrorStatus.INVALID_PARAMETER);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(ModelMap model) {
		
		Map<String, Object> response = blobService.generateUploadUrl("/blob/upload");
		String url = (String)response.get(ResponseParam.URL.getName());
		
		model.addAttribute("imageUrl", url);
		
		return "testblob";
	}
}
