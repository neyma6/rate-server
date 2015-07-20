package com.gabor.csatlos.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.entities.User;
import com.gabor.csatlos.service.UserService;
import com.gabor.csatlos.utils.ResponseBuilder;

// TODO: check bad request handling

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public Map<String, Object> register(@RequestParam String id,
										@RequestParam String name, 
										@RequestParam String password) {
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setFacebookUser(User.isFacebookUser(id));
		
		return userService.register(user);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Map<String, Object> update(@RequestParam String id,
									  @RequestParam String name, 
									  @RequestParam String password) {
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		
		return userService.update(user);
	}
	
	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Map<String, Object> get(@RequestParam String id,
								   @RequestParam String password) {
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		
		return userService.get(user);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> handleBadRequest(Exception ex) {
		LOGGER.error("UserController/handleBadRequest", ex);
		return ResponseBuilder.sendError(ErrorStatus.INVALID_PARAMETER);
	}
	
}
