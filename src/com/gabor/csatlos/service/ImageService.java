package com.gabor.csatlos.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.entities.Image;
import com.gabor.csatlos.utils.ResponseBuilder;
import com.google.appengine.api.datastore.Blob;
import com.googlecode.objectify.ObjectifyService;


@Service
public class ImageService {

	public Map<String, Object> upload(String id, String imageDataString) {
		 
		try {
			Blob imageData = new Blob(imageDataString.getBytes());
			
			Image image = new Image();
			image.setId(id);
			image.setImageData(imageData);
			
			ObjectifyService.ofy().save().entity(image).now();
			
			return ResponseBuilder.sendSuccess();
			
		} catch (Exception ex) {
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}
	}
	
	public Map<String, Object> get(String id) {
		
		try {
			Image image = ObjectifyService.ofy().load().type(Image.class).id(id).now();
			
			if (image == null) {
				return ResponseBuilder.sendError(ErrorStatus.IMAGE_NOT_EXISTS);
			}
			
			return ResponseBuilder.sendSuccess(image);
			
		} catch (Exception ex) {
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}
	}
}
