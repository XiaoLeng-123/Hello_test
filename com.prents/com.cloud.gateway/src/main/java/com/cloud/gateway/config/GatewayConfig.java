package com.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator myRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
		RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
		routes.route("pay_gateway",
				r -> r.path("/guoji")
						.uri("http://news.baidu.com/guoji")).build();
		return routes.build();
	}
	
}
