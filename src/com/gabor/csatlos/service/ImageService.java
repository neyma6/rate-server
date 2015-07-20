package com.gabor.csatlos.service;

import org.springframework.stereotype.Service;

import com.gabor.csatlos.entities.ImageUrl;
import com.googlecode.objectify.ObjectifyService;


@Service
public class ImageService {

	public String getImage(String id) {
		 
		try {
			
			ImageUrl imageUrl = ObjectifyService.ofy().load().type(ImageUrl.class).id(id).now();			
			return imageUrl != null ? imageUrl.getImageUrl() : "";
			
		} catch (Exception ex) {
			return "";
		}
	}
}
