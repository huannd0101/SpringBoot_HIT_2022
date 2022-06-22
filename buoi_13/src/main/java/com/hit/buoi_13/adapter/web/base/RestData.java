package com.hit.buoi_13.adapter.web.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class RestData<T> {

  private RestStatus status;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T userMessage;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonIgnore
  private String devMessage;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T data;

  public RestData() {
  }

  public RestData(T data) {
    this.status = RestStatus.SUCCESS;
    this.data = data;
  }

  public RestData(RestStatus status, T userMessage, T data) {
    this.status = status;
    this.userMessage = userMessage;
    this.data = data;
  }

  public RestData(RestStatus status, T userMessage, String devMessage, T data) {
    this.status = status;
    this.userMessage = userMessage;
    this.devMessage = devMessage;
    this.data = data;
  }

  public static RestData<?> error(Object userMessage, String devMessage) {
    return new RestData<>(RestStatus.ERROR, userMessage, devMessage, null);
  }

  public static RestData<?> error(Object userMessage) {
    return new RestData<>(RestStatus.ERROR, userMessage, null);
  }

  public RestStatus getStatus() {
    return status;
  }

  public void setStatus(RestStatus status) {
    this.status = status;
  }

  public T getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(T userMessage) {
    this.userMessage = userMessage;
  }

  public String getDevMessage() {
    return devMessage;
  }

  public void setDevMessage(String devMessage) {
    this.devMessage = devMessage;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

}
