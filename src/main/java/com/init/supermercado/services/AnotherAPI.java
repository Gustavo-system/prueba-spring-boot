package com.init.supermercado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AnotherAPI {
	
	LocalDate todaysDate = LocalDate.now();
	private final RestTemplate restTemplate;
	private static final Logger LOGGER=LoggerFactory.getLogger(AnotherAPI.class);
	
	@Autowired
	public AnotherAPI(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Object getAPI() {
		String url = "https://jsonplaceholder.typicode.com/posts";
		Object forObject = restTemplate.getForObject(url, Object.class);
		LOGGER.info("Peticion a otra api");
		return forObject;
	}
	
	
}
