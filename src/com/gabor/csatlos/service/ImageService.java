package com.gabor.csatlos.service;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.google.appengine.api.datastore.Blob;


@Service
public class ImageService {

	public Map<String, Object> upload(String imageDataString) {
		
		try {
			Blob imageData = new Blob(imageDataString.getBytes());
			
			
		} catch (Exception ex) {
			
		}
		
		return null;
	}
}
