package com.wuwc.provider_service.controller;

import com.wuwc.common.domain.User;
import com.wuwc.provider_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuwc
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getOne")
    public ResponseEntity<User> getOne(){
        return ResponseEntity.ok(userService.getOne());
    }

    @GetMapping("/getList")
    public ResponseEntity<List<User>> getList(){
        return ResponseEntity.ok(userService.getList());
    }

    @GetMapping("/get-service")
    public Object getCLient(){
        List<ServiceInstance> provider_service = discoveryClient.getInstances("PROVIDER_SERVICE");
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        provider_service.stream().forEach(entity->{
            System.out.println(entity.getHost()+"--"+entity.getInstanceId()+"--"+entity.getServiceId());
        });
        return discoveryClient;
    }



}
