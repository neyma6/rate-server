package com.gabor.csatlos.utils;

import java.util.HashMap;
import java.util.Map;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.domain.ResponeStatus;
import com.gabor.csatlos.domain.ResponseParam;
import com.gabor.csatlos.entities.Image;
import com.gabor.csatlos.entities.User;

public class ResponseBuilder {
	
	public static Map<String, Object> sendError(ErrorStatus status) {
		Map<String, Object> response = new HashMap<>();
		response.put(ResponseParam.STATUS.getName(), ResponeStatus.ERROR.getName());
		response.put(ResponseParam.ERROR.getName(), status.getName());
		
		return response;
	}
	
	public static Map<String, Object> sendSuccess(User user) {
		Map<String, Object> response = new HashMap<>();
		response.put(ResponseParam.STATUS.getName(), ResponeStatus.SUCCESS.getName());
		response.put(ResponseParam.USER.getName(), user);
		
		return response;
	}
	
	public static Map<String, Object> sendSuccess(Image image) {
		Map<String, Object> response = new HashMap<>();
		response.put(ResponseParam.STATUS.getName(), ResponeStatus.SUCCESS.getName());
		response.put(ResponseParam.IMAGE.getName(), image);
		
		return response;
	}
	
	public static Map<String, Object> sendSuccess(String url) {
		Map<String, Object> response = new HashMap<>();
		response.put(ResponseParam.STATUS.getName(), ResponeStatus.SUCCESS.getName());
		response.put(ResponseParam.URL.getName(), url);
		
		return response;
	}
	
	public static Map<String, Object> sendSuccess() {
		Map<String, Object> response = new HashMap<>();
		response.put(ResponseParam.STATUS.getName(), ResponeStatus.SUCCESS.getName());
		
		return response;
	}
	
}
