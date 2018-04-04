package com.lihui.cloud.eureka.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者-将调用 eureka-client 的接口
 *
 * Spring Cloud Commons 中提供了大量的与服务治理相关的抽象接口，
 * 包括 DiscoveryClient，此处使用 LoadBalancerClient（提供负载均衡功能）。
 */
@EnableFeignClients // 使用 Feign 服务消费工具时添加
@EnableEurekaClient
@SpringBootApplication
public class CloudEurekaConsumerApplication {
    @LoadBalanced   // 使用 Ribbon 服务消费工具时添加
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloudEurekaConsumerApplication.class).web(true).run(args);
    }
}
