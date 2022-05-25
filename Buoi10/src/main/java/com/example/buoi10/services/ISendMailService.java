package com.example.buoi10.services;

import org.springframework.web.multipart.MultipartFile;

public interface ISendMailService {
    String sendMailWithText(String sub, String content, String to);
    String sendMailWithAtt(String sub, String content, String to, MultipartFile[] att);
}
