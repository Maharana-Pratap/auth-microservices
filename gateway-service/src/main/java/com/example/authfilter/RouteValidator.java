package com.example.authfilter;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndPoints = List.of(
            "/auth/register",
            "/auth/token",
            "/auth/validate/**",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
            (request) -> openApiEndPoints.stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
