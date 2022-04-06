package com.hit.buoi6.config;


import com.github.slugify.Slugify;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Slugify slugify() {
        return new Slugify();
    }

}
