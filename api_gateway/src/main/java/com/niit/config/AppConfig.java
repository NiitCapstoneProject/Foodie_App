/*
*Author : Ankit Ambekar
*Date : 
Created with : IntelliJ IDEA Community Edition
*/
package com.niit.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator route (RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(p->p.path("/api/v2/**").uri("lb://UserAuthenticatonService"))
                .route(p->p.path("/api/v1/**").uri("lb://UserTrackService")).build();
    }
}
