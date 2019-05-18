package com.prototype.meteor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeteorApplication {

	public static Logger logger = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		SpringApplication.run(MeteorApplication.class, args);
		logger.trace("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));
		
	}

}
