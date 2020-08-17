package com.Test;

import java.net.URI;
import java.net.URISyntaxException;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sbtest.controllers.TestController;

public class ControllerTest {
	
  @Autowired
  private TestController testController;

  @Autowired
  ResourceLoader resourceLoader;
  
  @Test
  public void testConnectedCityYes() {
	  	RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080/connected?origin=Trenton&destination=Albany";
	    URI uri =null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("YES"));
	    
	    System.out.println(result.getBody());
  } 
  
  
  @Test
  public void testConnectedCityNO() {
	  	RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080/connected?origin=Boston&destination=Albany";
	    URI uri =null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("NO"));
	    
	    System.out.println(result.getBody());
  } 
}