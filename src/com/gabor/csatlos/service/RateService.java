package com.gabor.csatlos.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.entities.User;
import com.gabor.csatlos.utils.ResponseBuilder;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Service
public class RateService {

	private static final Logger LOGGER = Logger.getLogger(RateService.class);
	
	public Map<String, Object> get() {
		
		try {
			int userCount = ObjectifyService.ofy().load().type(User.class).count();
			int randomUserIndex = (int)(Math.random() * userCount);
			
			Key<User> userKey = ObjectifyService.ofy().load().type(User.class).keys().list().get(randomUserIndex);
			User user = ObjectifyService.ofy().load().type(User.class).id(userKey.getName()).now();
			
			return ResponseBuilder.sendSuccess(user);
			
		} catch(Exception ex) {
			LOGGER.error("RateService/get", ex);
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}
	}
	
	public Map<String, Object> set(String id, int rateValue) {
		
		try {
			User user = ObjectifyService.ofy().load().type(User.class).id(id).now();
			
			user.setRateValues(user.getRateValues() + rateValue);
			user.setNumberOfRates(user.getNumberOfRates() + 1);
			
			ObjectifyService.ofy().save().entity(user).now();
			
			return ResponseBuilder.sendSuccess();
			
		} catch (Exception ex) {
			LOGGER.error("RateService/set", ex);
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}
	}
}
