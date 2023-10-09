package com.app.blog.project.service.client.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.app.blog.project.client")
@Configuration
public class FeignConfig {

}
