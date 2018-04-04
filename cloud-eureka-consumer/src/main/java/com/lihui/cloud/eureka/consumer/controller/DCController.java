package com.lihui.cloud.eureka.consumer.controller;

import com.lihui.cloud.eureka.consumer.client.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/dc")
@RestController
public class DCController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用 eureka-client 的接口
     * @return
     */
    /*@GetMapping("/getDc")
    public String getDc() {
        // 在客户端中负载均衡选出 client
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        // 获取客户端 host，port 拼接 url
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/client/dc";
        System.out.println(url);
        // 调用 client 接口
        return restTemplate.getForObject(url, String.class);
    }*/

    /**
     * 使用 Ribbon 工具调用 eureka-client 接口
     * Spring Cloud Ribbon 是基于 Netflix Ribbon 实现的一套客户端负载均衡的工具。
     * 它是一个基于 HTTP 和 TCP 的客户端负载均衡器。它可以通过在客户端中配置 ribbonServerList 来设置服务端列表去轮询访问以达到均衡负载的作用
     * @return
     */
    @GetMapping("/getDc2")
    public String getDc2() {
        return restTemplate.getForObject("http://eureka-client/client/dc", String.class);
    }

    @Autowired
    private DcClient dcClient;

    /**
     * 使用 Feign 工具调用 eureka-client 接口
     * @return
     */
    @GetMapping("/getDc3")
    public String getDc() {
        return dcClient.consumer();
    }

}
