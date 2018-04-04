package com.lh.cloud.rhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务器容错保护
 * Spring Cloud Hystrix：Hystrix 具备了服务降级、服务熔断、线程隔离、请求缓存、请求合并以及服务监控等强大功能。
 * 服务消费者，调用 eureka-server 服务
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class CloudEurekaConsumerHystrixApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaConsumerHystrixApplication.class, args);
	}
}
