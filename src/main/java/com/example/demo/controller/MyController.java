package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hello")
// @Slf4j
public class MyController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MyController.class);

	@Autowired
	private ApplicationContext context;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String hello() {

		if (context.containsBean("buildProperties")) {
			BuildProperties buildProperties = context.getBean(BuildProperties.class);
			displayInfo(buildProperties);
		} else {
			log.info("No ${spring.info.build.location:classpath:META-INF/build-info.properties} found");
		}
		
		System.out.println("Log message from Hello World.");
		return "Hello World";
	}

	private void displayInfo(BuildProperties buildProperties) {
		if (buildProperties != null) {
			log.info("build version is: " + buildProperties.getVersion() );
			//log.info("value for custom key 'foo' is <" + buildProperties.get("foo") + ">");
		} else {
			log.info("No ${spring.info.build.location:classpath:META-INF/build-info.properties} found");
		}
	}

}
