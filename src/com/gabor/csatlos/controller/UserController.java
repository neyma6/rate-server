package com.gabor.csatlos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
//required = false because the controller should handle the error and send back a json instead of http status
public class UserController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public Map<String, Object> register(@RequestParam(required = false) String id,
										@RequestParam(required = false) String name, 
										@RequestParam(required = false) String password) {
		
		if (!isParamsValid(id, name, password)) {
			return ResponseBuilder.sendError(ErrorStatus.INVALID_PARAMETER);
		}
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setFacebookUser(User.isFacebookUser(id));
		
		return userService.register(user);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Map<String, Object> update(@RequestParam(required = false) String id,
									  @RequestParam(required = false) String name, 
									  @RequestParam(required = false) String password) {
		
		if (!isParamsValid(id, name, password)) {
			return ResponseBuilder.sendError(ErrorStatus.INVALID_PARAMETER);
		}
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		
		return userService.update(user);
	}
	
	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Map<String, Object> get(@RequestParam(required = false) String id,
								   @RequestParam(required = false) String password) {
		
		if (!isParamsValid(id, password)) {
			return ResponseBuilder.sendError(ErrorStatus.INVALID_PARAMETER);
		}
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		
		return userService.get(user);
	}
	
	private boolean isParamsValid(String... params) {
		for (String param : params) {
			if (!StringUtils.hasText(param)) {
				return false;
			}
		}
		return true;
	}
	
}
