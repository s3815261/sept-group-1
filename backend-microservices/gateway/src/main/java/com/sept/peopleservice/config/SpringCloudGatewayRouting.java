package com.sept.peopleservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("users", r->r.path("/users/**").uri("http://localhost:8081")) //static routing
//                .route("orderId", r->r.path("/order/**").uri("lb://ORDER-SERVICE")) //dynamic routing
//                .build();

        return builder.routes()
                .route("user-service", r -> r.path("/users/**").uri("lb://USER-SERVICE")).build();
//                .route(p -> p
//                        .path("/users/**")
//                        .uri("http://localhost:8081"))
//                .build();
//        return builder.routes()
//                .route(p -> p
//                        .path("/users/**")
//                        .uri("http://httpbin.org:81"))
//                .build();
    }
}
