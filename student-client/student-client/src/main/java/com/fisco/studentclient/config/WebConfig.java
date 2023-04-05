package com.fisco.studentclient.config;

import com.fisco.studentclient.service.StudentClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {
    @Bean
    public WebClient studentServiceWebClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }
    @Bean("studentClient")
    public StudentClientService studentClientService(){
        HttpServiceProxyFactory httpServiceProxyFactory   =HttpServiceProxyFactory.
                builder(WebClientAdapter.forClient(studentServiceWebClient()))
                .build();
        return  httpServiceProxyFactory.createClient(StudentClientService.class);
    }
}
