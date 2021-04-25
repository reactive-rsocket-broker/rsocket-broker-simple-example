package com.alibaba.user.springboot;

import com.alibaba.rsocket.invocation.RSocketRemoteServiceBuilder;
import com.alibaba.rsocket.upstream.UpstreamManager;
import com.alibaba.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class UserServicesAutoConfiguration {
    @Bean
    public UserService userService(UpstreamManager upstreamManager) {
        return RSocketRemoteServiceBuilder
                .client(UserService.class)
                .upstreamManager(upstreamManager)
                .build();
    }
}
