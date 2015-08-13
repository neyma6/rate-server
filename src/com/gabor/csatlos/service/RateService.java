package com.gabor.csatlos.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.entities.User;
import com.gabor.csatlos.utils.ResponseBuilder;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Service
public class RateService {

	@Autowired
	private ImageService imageService;
	
	private static final Logger LOGGER = Logger.getLogger(RateService.class);
	
	public Map<String, Object> get(String id) {
		
		try {
			User user;
			do {
				int userCount = ObjectifyService.ofy().load().type(User.class).count();
				int randomUserIndex = (int)(Math.random() * userCount);
				
				Key<User> userKey = ObjectifyService.ofy().load().type(User.class).keys().list().get(randomUserIndex);
				user = ObjectifyService.ofy().load().type(User.class).id(userKey.getName()).now();
			} while(id.equals(user.getId()));
			
			String imageUrl = imageService.getImage(user.getId());
			
			return ResponseBuilder.sendSuccess(user, imageUrl);
			
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
