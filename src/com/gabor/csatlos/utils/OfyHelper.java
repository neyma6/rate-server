package com.gabor.csatlos.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.gabor.csatlos.entities.TestEntity;
import com.gabor.csatlos.entities.User;
import com.googlecode.objectify.ObjectifyService;

public class OfyHelper implements ServletContextListener {
	  public void contextInitialized(ServletContextEvent event) {

	    ObjectifyService.register(TestEntity.class);
	    ObjectifyService.register(User.class);

	  }

	  public void contextDestroyed(ServletContextEvent event) {
	    // App Engine does not currently invoke this method.
	  }
	}
