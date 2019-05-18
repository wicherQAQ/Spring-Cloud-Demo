package com.wuwc.consumer.controller;

import com.wuwc.common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuwc
 */
@RestController
@RequestMapping("/consumer")
public class MyResource {

    private final String REST_URL_PREFIX = "http://localhost:8080";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getOne")
    public ResponseEntity<User> testConsumer(){
        return restTemplate.getForEntity(REST_URL_PREFIX+"/user/getOne",User.class);
    }

}
