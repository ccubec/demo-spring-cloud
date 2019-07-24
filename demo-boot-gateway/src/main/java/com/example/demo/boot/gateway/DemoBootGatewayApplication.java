package com.example.demo.boot.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoBootGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBootGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("path_route", r -> r.path("/get")
						.uri("http://httpbin.org"))
				.route("path_route1", r -> r.path("/get1")
						.uri("https://www.baidu.com"))
				.route("path_route2", r -> r.path("/get")
						.uri("http://httpbin.org"))
				.build();
	}

}
