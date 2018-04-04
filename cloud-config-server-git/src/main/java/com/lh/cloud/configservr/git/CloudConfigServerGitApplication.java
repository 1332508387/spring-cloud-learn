package com.lh.cloud.configservr.git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring Cloud Config: 分布式配置中心
 * Config Server 从 GitHub 读取配置文件
 * 访问：http://localhost:8003/config-client/dev/master
 */
@EnableConfigServer
@SpringBootApplication
public class CloudConfigServerGitApplication {

	public static void main(String[] args) {
//		new SpringApplicationBuilder(CloudConfigServerGitApplication.class).web(true).run(args);
		SpringApplication.run(CloudConfigServerGitApplication.class, args);
	}
}
