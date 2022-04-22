package com.example.buoi10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;

@Service
public class SendMailServiceImp implements ISendMailService{


    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendMailWithText(String sub, String content, String to) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setSubject(sub);
            simpleMailMessage.setText(content);
            simpleMailMessage.setTo(to);

            javaMailSender.send(simpleMailMessage);
        }catch (Exception e) {
            return "Send failed";
        }

        return "Send successfully";
    }
    @Override
    public String sendMailWithAtt(String sub, String content, String to, MultipartFile[] att) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(sub);
            helper.setText(content);

            if(att != null && att.length > 0) {
                for(MultipartFile multipartFile : att) {
                    helper.addAttachment(multipartFile.getName(), multipartFile);
                }
            }

            javaMailSender.send(message);

        }catch (Exception e) {
            return "Send failed";
        }
        return "Send successfully";
    }
}
