package com.lh.cloud.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix Dashboard: Hystrix 监控面板
 *
 * @SpringCloudApplicetion <==>
 *     @SpringBootApplication
 *     @EnableDiscoveryClient
 *     @EnableCircuitBreaker
 */
@EnableHystrixDashboard
@SpringCloudApplication
public class CloudHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudHystrixDashboardApplication.class, args);
	}
}
