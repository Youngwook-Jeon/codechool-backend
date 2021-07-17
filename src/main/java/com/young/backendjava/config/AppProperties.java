package com.young.backendjava.config;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppProperties {

    private final Environment environment;

    public String getTokenSecret() {
        return environment.getProperty("token.secret");
    }
}
