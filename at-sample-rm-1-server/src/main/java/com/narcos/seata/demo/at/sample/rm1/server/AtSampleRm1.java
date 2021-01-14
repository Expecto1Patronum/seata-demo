package com.narcos.seata.demo.at.sample.rm1.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author hbj
 * @date 2021/1/14 3:42 下午
 */
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients(basePackages = "com.narcos.*")
public class AtSampleRm1 {
    public static void main(String[] args) {
        SpringApplication.run(AtSampleRm1.class, args);
    }
}
