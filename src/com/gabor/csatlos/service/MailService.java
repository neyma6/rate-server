package com.gabor.csatlos.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.entities.User;
import com.gabor.csatlos.utils.ResponseBuilder;
import com.googlecode.objectify.ObjectifyService;

@Service
public class MailService {

	@Autowired
    private JavaMailSender mailSender;
	
	public Map<String, Object> sendMail(String userId) {
		
		User userFromDb = ObjectifyService.ofy().load().type(User.class).id(userId).now();
		if (userFromDb == null || userFromDb.isFacebookUser()) {
			return ResponseBuilder.sendError(ErrorStatus.INVALID_USER);
		}
		
		try {
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(userFromDb.getId());
			email.setSubject("Rate Me - Forgotten password notification");
			email.setText("Dear " + userFromDb.getName() + "\n\n" +
					"You requested a password reminder from the Rate Me app. \n\n"+
					"User: " + userFromDb.getId() + "\n"+
					"Password: " + userFromDb.getPassword() + "\n\n" + 
					"Best regards, \n Gabor Csatlos");
			
			mailSender.send(email);
			return ResponseBuilder.sendSuccess();
		} catch (Exception ex) {
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}
	}
}
