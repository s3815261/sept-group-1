package com.sept.peopleservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**").uri("lb://USER-SERVICE"))
                .route("doctor-service", r -> r.path("/doctor/**").uri("lb://DOCTOR-SERVICE"))
                .route("appointment-service", r -> r.path("/appointment/**").uri("lb://APPOINTMENT-SERVICE"))
                .build();
    }
}
