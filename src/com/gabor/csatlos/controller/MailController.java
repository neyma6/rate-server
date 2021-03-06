package com.gabor.csatlos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabor.csatlos.service.MailService;

@Controller
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private MailService mailService;
	
	@ResponseBody
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public Map<String, Object> forgetPassword(@RequestParam String id) {
		
		return mailService.sendMail(id);
	}
}
