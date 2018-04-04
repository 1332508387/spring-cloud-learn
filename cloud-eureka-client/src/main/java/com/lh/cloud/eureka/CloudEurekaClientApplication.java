package com.lh.cloud.eureka;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudEurekaClientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(CloudEurekaClientApplication.class).web(true).run(args);
	}

}
