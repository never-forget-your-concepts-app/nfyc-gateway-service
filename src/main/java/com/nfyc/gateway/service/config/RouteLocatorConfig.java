package com.nfyc.gateway.service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
    return builder.routes()
      .route("studyplanservice", r -> r.path("/studyplan/**")
        .filters(f -> f.stripPrefix(1))
        .uri("lb://STUDY-PLAN-SERVICE"))
      .route("revisionservice", r -> r.path("/revision/**")
        .filters(f -> f.stripPrefix(1))
        .uri("lb://STUDY-REVISION-SERVICE"))
      .build();
  }
}
