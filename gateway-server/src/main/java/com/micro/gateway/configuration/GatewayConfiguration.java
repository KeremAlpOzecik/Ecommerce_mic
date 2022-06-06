package com.micro.gateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.micro.gateway.filter.AuthFilter;
import com.micro.gateway.filter.AuthFilterConfig;

@Configuration
public class GatewayConfiguration {

	@Autowired
	private AuthFilter authenticationFilter;

	@Bean
	public RouteLocator gateWayRoutes(RouteLocatorBuilder builder) {
		return builder.routes().route("user-service", r -> r.path("/users/**")
						.filters(f -> f.filter(authenticationFilter.apply(new AuthFilterConfig()))).uri("lb://user-service"))
				.route("order-service",
						r -> r.path("/order/**")
								.filters(f -> f.filter(authenticationFilter.apply(new AuthFilterConfig())))
								.uri("lb://order-service"))
				.route("order-service",
						r -> r.path("/cart/**")
								.filters(f -> f.filter(authenticationFilter.apply(new AuthFilterConfig())))
								.uri("lb://order-service"))
				.route("product-catalog-service",
						r -> r.path("/products/**")
								.filters(f -> f.filter(authenticationFilter.apply(new AuthFilterConfig())))
								.uri("lb://product-catalog-service"))
				.route("payment-service",
						r -> r.path("/payments/**")
								.filters(f -> f.filter(authenticationFilter.apply(new AuthFilterConfig())))
								.uri("lb://payment-service"))
				.build();

	}
}
