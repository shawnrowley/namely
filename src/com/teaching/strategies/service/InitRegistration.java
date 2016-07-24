package com.teaching.strategies.service;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class InitRegistration {
	
	@Inject
    private Logger log;

	public InitRegistration() {
		
	}
	
	/**
	 * Initalization will contain properties to used 
	 * by all
	 * 
	 */
	@PostConstruct
	public void startup() {
		log.info("Starting Name Manager Service");
	}

}
