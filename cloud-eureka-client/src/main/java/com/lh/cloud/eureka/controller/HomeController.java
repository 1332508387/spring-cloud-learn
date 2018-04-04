package com.lh.cloud.eureka.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/client")
@RestController
public class HomeController {
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
//        Thread.sleep(5000);
        String services = "Services:" + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
