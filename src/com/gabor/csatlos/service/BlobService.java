package com.gabor.csatlos.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.gabor.csatlos.domain.ErrorStatus;
import com.gabor.csatlos.entities.ImageUrl;
import com.gabor.csatlos.utils.ResponseBuilder;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.googlecode.objectify.ObjectifyService;

@Service
public class BlobService {

	private static final Logger LOGGER = Logger.getLogger(BlobService.class);
	
	private final BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	public Map<String, Object> generateUploadUrl(String path) {
		
		try {
		String uploadURI = blobstoreService.createUploadUrl(path);
			return ResponseBuilder.sendSuccess(uploadURI);
		} catch (Exception ex) {
			LOGGER.error("BlobService/generateUploadUrl", ex);
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}
	}
	
	public Map<String, Object> upload(HttpServletRequest request) {
		
		try {
			Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
		    BlobKey blob = blobs.get("defaultImage").get(0);
		         
		    ImagesService imagesService = ImagesServiceFactory.getImagesService();
		    ServingUrlOptions options = ServingUrlOptions.Builder.withBlobKey(blob);
		    
		    String imageUrl = imagesService.getServingUrl(options);
		    String userid = request.getParameter("userid");
		    
		    ImageUrl imageUrlObj = new ImageUrl(userid, imageUrl);
		    
		    ObjectifyService.ofy().save().entity(imageUrlObj).now();
		    
		    return ResponseBuilder.sendSuccess(imageUrl);
		} catch (Exception ex) {
			LOGGER.error("BlobService/upload", ex);
			return ResponseBuilder.sendError(ErrorStatus.ERROR_OCCURED);
		}
	}
}
