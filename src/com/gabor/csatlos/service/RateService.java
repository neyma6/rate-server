package com.gabor.csatlos.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.gabor.csatlos.entities.User;
import com.gabor.csatlos.utils.ResponseBuilder;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Service
public class RateService {

	public Map<String, Object> get() {
		
		try {
			int userCount = ObjectifyService.ofy().load().type(User.class).count();
			Key<User> userKey = ObjectifyService.ofy().load().type(User.class).keys().list().get((int)(Math.random() % userCount));
			User user = ObjectifyService.ofy().load().type(User.class).id(userKey.getName()).now();
			
			return ResponseBuilder.sendSuccess(user);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
