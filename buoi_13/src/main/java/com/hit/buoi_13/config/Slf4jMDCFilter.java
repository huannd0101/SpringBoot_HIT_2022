package com.hit.buoi_13.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class Slf4jMDCFilter extends OncePerRequestFilter {

  private static final String PREFIX_TOKEN = "x-tracking-";

  private final String responseHeader;
  private final String mdcTokenKey;
  private final String mdcClientIpKey;
  private final String mdcHttpMethod;
  private final String mdcHttpUri;
  private final String requestHeader;

  public Slf4jMDCFilter() {
    responseHeader = Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER;
    mdcTokenKey = Slf4jMDCFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY;
    mdcClientIpKey = Slf4jMDCFilterConfiguration.DEFAULT_MDC_CLIENT_IP_KEY;
    this.mdcHttpMethod = Slf4jMDCFilterConfiguration.DEFAULT_MDC_HTTP_METHOD;
    this.mdcHttpUri = Slf4jMDCFilterConfiguration.DEFAULT_MDC_HTTP_URI;
    requestHeader = null;
  }

  public Slf4jMDCFilter(final String responseHeader, final String mdcTokenKey, final String mdcClientIPKey,
                        final String mdcHttpMethod, final String mdcHttpUri, final String requestHeader) {
    this.responseHeader = responseHeader;
    this.mdcTokenKey = mdcTokenKey;
    this.mdcClientIpKey = mdcClientIPKey;
    this.mdcHttpMethod = mdcHttpMethod;
    this.mdcHttpUri = mdcHttpUri;
    this.requestHeader = requestHeader;
  }

  @Override
  protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                                  final FilterChain chain)
      throws java.io.IOException, ServletException {
    try {
      final String token = extractToken(request);
      final String clientIP = extractClientIP(request);
      final String httpMethod = extractHttpMethod(request);
      final String httpUri = extractHttpUri(request);
      MDC.put(mdcClientIpKey, clientIP);
      MDC.put(mdcTokenKey, token);
      MDC.put(mdcHttpMethod, httpMethod);
      MDC.put(mdcHttpUri, httpUri);
      if (StringUtils.hasText(responseHeader)) {
        response.addHeader(responseHeader, token);
      }
      chain.doFilter(request, response);
    } finally {
      MDC.remove(mdcTokenKey);
      MDC.remove(mdcClientIpKey);
      MDC.remove(mdcHttpMethod);
      MDC.remove(mdcHttpUri);
    }
  }

  private String extractToken(final HttpServletRequest request) {
    final String token;
    if (StringUtils.hasText(requestHeader) && StringUtils.hasText(request.getHeader(requestHeader))) {
      token = request.getHeader(requestHeader);
    } else {
      token = PREFIX_TOKEN + UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }
    return token;
  }

  private String extractClientIP(final HttpServletRequest request) {
    final String clientIP;
    if (request.getHeader("X-Forwarded-For") != null) {
      clientIP = request.getHeader("X-Forwarded-For").split(",")[0];
    } else {
      clientIP = request.getRemoteAddr();
    }
    return clientIP;
  }

  private String extractHttpMethod(final HttpServletRequest request) {
    return request.getMethod();
  }

  private String extractHttpUri(final HttpServletRequest request) {
    return request.getRequestURI();
  }

  @Override
  protected boolean isAsyncDispatch(final HttpServletRequest request) {
    return false;
  }

  @Override
  protected boolean shouldNotFilterErrorDispatch() {
    return false;
  }

}
