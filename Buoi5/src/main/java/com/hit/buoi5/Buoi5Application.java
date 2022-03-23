package com.hit.buoi5;

import com.github.slugify.Slugify;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication
public class Buoi5Application {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true);
        return modelMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Buoi5Application.class, args);


        Slugify slg = new Slugify();

        slg = slg.withCustomReplacements(new HashMap<>() {{
            put("hello", "1231");
            put("Huân", "HIT");
        }});

        String str = "hello Biên Huân abc 123";

        System.out.println(slg.slugify(str));
//        huan-abc-123

    }

}
