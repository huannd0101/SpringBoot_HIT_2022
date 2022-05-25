package com.ehit.sercurity.service;

import com.ehit.sercurity.model.User;
import com.ehit.sercurity.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
  private final UserRepository userRepository;

  public MyUserDetailService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
        List.of(new SimpleGrantedAuthority(user.getRole().getName()))); //Thêm quyền lúc trả về
  }

}
