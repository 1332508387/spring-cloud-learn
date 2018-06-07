package com.lh.cloudapigateway;

import com.lh.cloudapigateway.filter.AccessFilter;
import com.lh.cloudapigateway.filter.AccessFilter2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 服务网关 Zuul
 * 路由功能：
 * 		Spring Cloud Zuul 注册到 eureka-server 后，具备默认的服务路由功能，注册之后，Zuul 发现启动了量个服务 eureka-client 和 eureka-hystrix-consumer，这时候 Zuul
 * 		会创建两个路由规则。每个路由规则都包含两部分，一部分是外部请求的匹配规则，另一部分是路由的服务 ID。如针对 eureka-client 和 eureka-hystrix-consumer 服务会创建下面两个路由规则：
 * 			对于 /eureka-client/** 的请求，转发到 eureka-client
 * 			对于 /eureka-hystrix-consumer/** 的请求，转发到 eureka-hystrix-consumer
 * 		例：访问 http://127.0.0.1:8300/eureka-client/client/dc，将被路由到 eureka-client 的 /client/dc 接口上
 * 过滤器功能：
 * 		Zuul允许开发者在API网关上通过定义过滤器来实现对请求的拦截与过滤，继承 ZuulFilter 抽象类并实现其抽象方法。
 */
@EnableZuulProxy
@SpringBootApplication
public class CloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApiGatewayApplication.class, args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

	@Bean
	public AccessFilter2 accessFilter2() {
		return new AccessFilter2();
	}
}
