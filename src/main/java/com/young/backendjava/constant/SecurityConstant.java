package com.young.backendjava.constant;

import com.young.backendjava.SpringApplicationContext;
import com.young.backendjava.config.AppProperties;

public class SecurityConstant {

    public static final long EXPIRATION_DATE = 1000 * 60 * 60 * 24 * 5L; // 5 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTH_HEADER = "Authorization";
    public static final String SIGN_UP_URL = "/users";

    public static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
        return appProperties.getTokenSecret();
    }
}
