package com.hit.buoi9.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
public class UploadFile {

//  @Autowired
//  private Cloudinary cloudinary;
//
//  public String getUrlFromFile(MultipartFile multipartFile) {
//    try {
//      Map<?, ?> map = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
//      map.values().forEach(System.out::println);
//      return map.get("secure_url").toString();
//    } catch (IOException e) {
//      return null;
//    }
//  }
//
//  public void removeImageFromUrl(String url) {
//    try {
//      cloudinary.uploader().destroy(url, ObjectUtils.emptyMap());
//    } catch (IOException e) {
//    }
//  }


}
