package com.lh.cloud.rhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DcService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String getDc() {
        // 主逻辑
        System.out.println("getDc...");
        return restTemplate.getForObject("http://eureka-client/client/dc", String.class);
    }

    /**
     * 服务降级：将在调用服务(getDc)失败时调用降级逻辑
     * 断路由：当调用的服务不可用时，产生调用堆积，此时断路由发挥作用。
     *      断路器未打开之前，每个请求都会在当调用服务超时之后返回执行降级逻辑（fallback）。当熔断器在10秒内发现请求总数超过20，并且错误百分比超过50%，这个时候熔断器打开。打开之后，再有请求调用的时候，将不会调用主逻辑（getDc），而是直接调用降级逻辑，这个时候就不会等待访问超时之后才返回fallback。通过断路器，实现了自动地发现错误并将降级逻辑切换为主逻辑，减少响应延迟的效果。
     *      主逻辑恢复：当断路器打开，对主逻辑进行熔断之后，Hystrix 会启动一个休眠时间窗，在这个时间窗内，降级逻辑是临时的成为主逻辑，当休眠时间窗到期，断路器将进入半开状态，释放一次请求到原来的主逻辑上，如果此次请求正常返回，那么断路器将继续闭合，主逻辑恢复，如果这次请求依然有问题，断路器继续进入打开状态，休眠时间窗重新计时。
     * @return
     */
    public String fallback() {
        // 降级逻辑
        return "服务调用超时";
    }
}
