package com.hit.buoi_13.adapter.web.v1.transfer.response;

import org.springframework.http.HttpHeaders;

public interface ResponseHeader {

  public HttpHeaders getHeader();

  public HttpHeaders postHeader();

  public HttpHeaders putHeader();

  public HttpHeaders deleteHeader();

}
