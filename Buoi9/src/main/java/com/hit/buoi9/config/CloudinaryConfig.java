package com.hit.buoi9.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary config() {
        Map<String,String> config = new HashMap<>();
        config.put("cloud_name", "none01");
        config.put("api_key", "975898585293148");
        config.put("api_secret", "JJqFPcPDDF08WM4hL-K4ysUbXzo");
        return new Cloudinary(config);
    }

}
