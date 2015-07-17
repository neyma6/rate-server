package com.gabor.csatlos;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;

import entities.TestEntity;

public class OfyHelper implements ServletContextListener {
	  public void contextInitialized(ServletContextEvent event) {
	    // This will be invoked as part of a warmup request, or the first user
	    // request if no warmup request was invoked.
	    ObjectifyService.register(TestEntity.class);

	  }

	  public void contextDestroyed(ServletContextEvent event) {
	    // App Engine does not currently invoke this method.
	  }
	}
