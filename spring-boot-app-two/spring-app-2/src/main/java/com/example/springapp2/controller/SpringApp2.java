package com.example.springapp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class SpringApp2 {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/invokeApp1")
    public static String invoke_spring_app_1()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        final String uri = "http://spring-app-1:8080/hello"; //spring-app-1; container name

        RestTemplate restTemplate = new RestTemplate();
        final String response = (String) restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();
        System.out.println("response output"+response);
        return response;
    }
	
    //for testing, 8090 working
    @RequestMapping("/test")
    public static String test_method()
    {
        return "8090 port is Working";
    }
}
