package com.gabor.csatlos.utils;

import java.util.HashMap;
import java.util.Map;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.domain.ResponeStatus;
import com.gabor.csatlos.domain.ResponseParam;
import com.gabor.csatlos.entities.User;

// TODO: refactor this
public class ResponseBuilder {
	
	public static Map<String, Object> sendError(ErrorStatus status) {
		Map<String, Object> response = new HashMap<>();
		addStatus(response, ResponeStatus.ERROR);
		response.put(ResponseParam.ERROR.getName(), status.getName());
		
		return response;
	}
	
	public static Map<String, Object> sendSuccess(User user) {
		Map<String, Object> response = new HashMap<>();
		addStatus(response, ResponeStatus.SUCCESS);
		addUser(response, user);
		
		return response;
	}
	
	
	public static Map<String, Object> sendSuccess(String url) {
		Map<String, Object> response = new HashMap<>();
		addStatus(response, ResponeStatus.SUCCESS);
		addUrl(response, url);
		
		return response;
	}
	
	public static Map<String, Object> sendSuccess(User user, String url) {
		Map<String, Object> response = new HashMap<>();
		addStatus(response, ResponeStatus.SUCCESS);
		addUrl(response, url);
		addUser(response, user);
		
		return response;
	}
	
	public static Map<String, Object> sendSuccess() {
		Map<String, Object> response = new HashMap<>();
		addStatus(response, ResponeStatus.SUCCESS);
		
		return response;
	}
	
	private static void addUser(Map<String, Object> responseMap, User user) {
		responseMap.put(ResponseParam.USER.getName(), user);
	}
	
	private static void addUrl(Map<String, Object> responseMap, String url) {
		responseMap.put(ResponseParam.URL.getName(), url);
	}
	
	private static void addStatus(Map<String, Object> responseMap, ResponeStatus status) {
		responseMap.put(ResponseParam.STATUS.getName(), status.getName());
	}
	
	
}
