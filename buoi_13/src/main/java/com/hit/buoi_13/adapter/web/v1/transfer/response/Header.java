package com.hit.buoi_13.adapter.web.v1.transfer.response;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component("WebV1TransferResponseHeader")
public class Header implements ResponseHeader {
  @Override
  public HttpHeaders getHeader() {
    // ヘッダー作成
    HttpHeaders headers = buildHeaderCommon();
    headers.add("Access-Control-Allow-Methods", "GET,OPTIONS");
    return headers;
  }

  @Override
  public HttpHeaders postHeader() {
    // ヘッダー作成
    HttpHeaders headers = buildHeaderCommon();
    headers.add("Access-Control-Allow-Methods", "POST,OPTIONS");
    return headers;
  }

  @Override
  public HttpHeaders putHeader() {
    // ヘッダー作成
    HttpHeaders headers = buildHeaderCommon();
    headers.add("Access-Control-Allow-Methods", "PUT,OPTIONS");
    return headers;
  }

  @Override
  public HttpHeaders deleteHeader() {
    // ヘッダー作成
    HttpHeaders headers = buildHeaderCommon();
    headers.add("Access-Control-Allow-Methods", "DELETE,OPTIONS");
    return headers;
  }

  private HttpHeaders buildHeaderCommon() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", "*");
    headers.add("Access-Control-Allow-Headers", "X-From, Authorization, Content-Type, X-Authorization");
    headers.add("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
    headers.add("Cache-Control", "no-cache=\"set-cookie\"");
    headers.add("Content-type", "application/json; charset=utf-8");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Robots-Tag", "noindex, nofollow");
    return headers;
  }

}
