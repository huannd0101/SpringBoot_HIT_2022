package com.hit.buoi_13.application.constant;

public class UrlConstant {

  public static final class User {
    private User() {
    }

    private static final String PREFIX = "/users";
    public static final String GET_LIST_USER = PREFIX;
  }

  public static final class Course {
    private Course() {
    }

    private static final String PREFIX = "/courses";
    public static final String GET_LIST_COURSE = PREFIX;
  }

}
