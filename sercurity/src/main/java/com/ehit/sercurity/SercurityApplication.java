package com.ehit.sercurity;

import com.ehit.sercurity.constant.RoleConstant;
import com.ehit.sercurity.model.Role;
import com.ehit.sercurity.model.User;
import com.ehit.sercurity.repository.RoleRepository;
import com.ehit.sercurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SercurityApplication {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  public static void main(String[] args) {
    SpringApplication.run(SercurityApplication.class, args);
  }

  @Bean
  CommandLineRunner init() {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    return args -> {
      if (roleRepository.count() == 0) {
        roleRepository.save(new Role(null, RoleConstant.ROLE_ADMIN, new ArrayList<>()));
        roleRepository.save(new Role(null, RoleConstant.ROLE_USER, new ArrayList<>()));
      }

      if (userRepository.count() == 0) {
        userRepository.save(new User("admin", passwordEncoder.encode("admin")));
      }

    };
  }

}


//      Map<Map<Long, Long>, String> mapStringMap;
//      Filter;
//      Security: phân quyền - jwt
//      Tách file application
//      Validation input
//      Messages.properties