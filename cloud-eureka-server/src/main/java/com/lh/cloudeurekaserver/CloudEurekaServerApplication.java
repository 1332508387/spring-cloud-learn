package com.lh.cloudeurekaserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 *
 * 使用 Spring Cloud Eureka 来实现服务治理
 * Spring Cloud Eureka 是Spring Cloud Netflix 项目下的服务治理模块。
 * 而 Spring Cloud Netflix 项目是 Spring Cloud 的子项目之一，主要内容是对 Netflix 公司一系列开源产品的包装，
 * 它为 Spring Boot 应用提供了自配置的 Netflix OSS 整合。通过一些简单的注解，开发者就可以快速的在应用中配置一下常用模块并构建庞大的分布式系统。
 * 它主要提供的模块包括：服务发现（Eureka），断路器（Hystrix），智能路由（Zuul），客户端负载均衡（Ribbon）等。
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloudEurekaServerApplication.class).web(true).run(args);
    }
}
