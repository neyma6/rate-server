package com.gabor.csatlos.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.entities.ImageUrl;
import com.gabor.csatlos.entities.User;
import com.gabor.csatlos.utils.ResponseBuilder;
import com.googlecode.objectify.ObjectifyService;

@Service
public class UserService {

	@Autowired
	private ImageService imageService;
	
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	public Map<String, Object> register(User user) {
		
		try {
			User userFromDb = ObjectifyService.ofy().load().type(User.class).id(user.getId()).now();
			if (userFromDb != null) {
				LOGGER.error("UserService/register - userFromDb is null");
				return ResponseBuilder.sendError(ErrorStatus.USER_EXISTS);
			}
			
			user.setNumberOfRates(0);
			user.setRateValues(0);
			
			ObjectifyService.ofy().save().entity(user).now();
			
			return ResponseBuilder.sendSuccess(user);
		} catch (Exception ex) {
			LOGGER.error("UserService/register", ex);
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}		
	}
	
	public Map<String, Object> get(User user) {
		
		try {
			User userFromDb = ObjectifyService.ofy().load().type(User.class).id(user.getId()).now();
			if (!userFromDb.isFacebookUser() && !userFromDb.getPassword().equals(user.getPassword())) {
				LOGGER.error("UserService/get - user creditials was wrong");
				return ResponseBuilder.sendError(ErrorStatus.INVALID_USER);
			}
			
			String imageUrl = imageService.getImage(userFromDb.getId());
					
			return ResponseBuilder.sendSuccess(userFromDb, imageUrl);
		} catch (Exception ex) {
			LOGGER.error("UserService/get", ex);
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
			LOGGER.error("UserService/update", ex);
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}		
	}
}
