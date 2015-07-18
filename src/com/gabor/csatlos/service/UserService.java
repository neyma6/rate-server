package com.gabor.csatlos.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.entities.User;
import com.gabor.csatlos.utils.ResponseBuilder;
import com.googlecode.objectify.ObjectifyService;

@Service
public class UserService {

	public Map<String, Object> register(User user) {
		
		try {
			User userFromDb = ObjectifyService.ofy().load().type(User.class).id(user.getId()).now();
			if (userFromDb != null) {
				return ResponseBuilder.sendError(ErrorStatus.USER_EXISTS);
			}
			
			user.setNumberOfRates(0);
			user.setRateValues(0.0f);
			
			ObjectifyService.ofy().save().entity(user).now();
			
			return ResponseBuilder.sendSuccess(user);
		} catch (Exception ex) {
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}		
	}
	
	public Map<String, Object> get(User user) {
		
		try {
			User userFromDb = ObjectifyService.ofy().load().type(User.class).id(user.getId()).now();
			if (!userFromDb.getPassword().equals(user.getPassword())) {
				return ResponseBuilder.sendError(ErrorStatus.INVALID_USER);
			}
			
			return ResponseBuilder.sendSuccess(userFromDb);
		} catch (Exception ex) {
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}		
	}
	
	public Map<String, Object> update(User user) {
		
		try {
			User userFromDb = ObjectifyService.ofy().load().type(User.class).id(user.getId()).now();
			userFromDb.setName(user.getName());
			userFromDb.setPassword(user.getPassword());
			
			ObjectifyService.ofy().save().entity(userFromDb).now();
			
			return ResponseBuilder.sendSuccess(userFromDb);
		} catch (Exception ex) {
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}		
	}
}
