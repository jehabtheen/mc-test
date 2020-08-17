package com.sbtest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/connected")
public class TestController {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	@Autowired
	ResourceLoader resourceLoader;
	
	@GetMapping
	public String cityConnected(@RequestParam(value="origin") String origin,
			@RequestParam(value="destination") String destination) {

		String isFlag="origin : "+ origin +  "  destination: "+  destination 
				+ " Connected Status :" +  this.checkConnection(origin,destination);

		return isFlag;
	}
	
	public String checkConnection(String origin, String destination){
		String isFlag="NO";
		//Resource resource = new ClassPathResource("classpath:city.txt");
		Resource resource = resourceLoader.getResource("classpath:city.txt");
	        try {
	        	InputStream inputStream = resource.getInputStream();
	            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
	            String data = new String(bdata, StandardCharsets.UTF_8);
	            LOGGER.info(data);
	            String[] values = StringUtils.split(data,"\n");
	            String citiesCheck =origin+", "+destination;
	            if(data !=null && data.contains(origin) && data.contains(destination) ){
		            if(data !=null && data.contains(citiesCheck)){
		            	isFlag="YES";
		            }
	            } 
	            LOGGER.info("Lenght :" +values.length);
	           /* for(String value:values){
	            	LOGGER.info("Values city :" +values.toString());
	            	String[] cities = StringUtils.split(new String(value),",");
		            if(cities.length > 0 && cities.length == 2){
		            	LOGGER.info("City Lenght :" +cities.length);
		            	if(cities[0].trim().equalsIgnoreCase(origin) &&
		            			cities[1].trim().equalsIgnoreCase(destination)	){
		            		isFlag="YES";
		            	}
		            }
	            }*/
	        } catch (IOException e) {
	            LOGGER.error("IOException", e);
	        }
		
		return isFlag;
	}

}
