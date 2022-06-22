package com.hit.buoi_13.config;

import lombok.Data;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class Slf4jMDCFilterConfiguration {

  public static final String DEFAULT_RESPONSE_TOKEN_HEADER = "x-tracking";
  public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "Slf4jMDCFilter.UUID";
  public static final String DEFAULT_MDC_CLIENT_IP_KEY = "Slf4jMDCFilter.ClientIP";
  public static final String DEFAULT_MDC_HTTP_METHOD = "Slf4jMDCFilter.HttpMethod";
  public static final String DEFAULT_MDC_HTTP_URI = "Slf4jMDCFilter.HttpUri";

  private String responseHeader = DEFAULT_RESPONSE_TOKEN_HEADER;
  private String mdcTokenKey = DEFAULT_MDC_UUID_TOKEN_KEY;
  private String mdcClientIpKey = DEFAULT_MDC_CLIENT_IP_KEY;
  private String mdcHttpMethod = DEFAULT_MDC_HTTP_METHOD;
  private String mdcHttpUri = DEFAULT_MDC_HTTP_URI;
  private String requestHeader = null;

  @Bean
  public FilterRegistrationBean<Slf4jMDCFilter> servletRegistrationBean() {
    final FilterRegistrationBean<Slf4jMDCFilter> registrationBean = new FilterRegistrationBean<>();
    final Slf4jMDCFilter log4jMDCFilterFilter = new Slf4jMDCFilter(responseHeader, mdcTokenKey, mdcClientIpKey,
        mdcHttpMethod, mdcHttpUri, requestHeader);
    registrationBean.setFilter(log4jMDCFilterFilter);
    registrationBean.setOrder(2);
    return registrationBean;
  }

}
