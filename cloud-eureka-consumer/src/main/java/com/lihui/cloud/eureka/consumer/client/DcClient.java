package com.lihui.cloud.eureka.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface DcClient {
    @GetMapping("/client/dc")
    String consumer();
}
