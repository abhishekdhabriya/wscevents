package com.srs.application.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Defines all constants related to the application
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppConstant {

    /**
     * DateTime custom API formats
     */
    public static final String LOCAL_DATE_FORMAT = "dd-MM-yyyy";
    public static final String LOCAL_DATE_TIME_FORMAT = "dd-MM-yyyy__HH:mm:ss:SSSSSS";
    public static final String ZONED_DATE_TIME_FORMAT = "dd-MM-yyyy__HH:mm:ss:SSSSSS";

    /**
     * Whitelist urls to be authorised with http security
     */
    public static final String[] WHITELIST_URLS = {
            "/",
            "/h2-console/**",
            "/api/v*/authenticate/**",
            "/api/v*/register/**",
    };

}
