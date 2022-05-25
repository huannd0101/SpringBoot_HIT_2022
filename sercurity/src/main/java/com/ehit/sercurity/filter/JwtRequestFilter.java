package com.ehit.sercurity.filter;

import com.ehit.sercurity.service.MyUserDetailService;
import com.ehit.sercurity.util.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class JwtRequestFilter extends OncePerRequestFilter {
  private final MyUserDetailService myUserDetailService;
  private final JwtUtil jwtUtil;

  public JwtRequestFilter(MyUserDetailService myUserDetailService, JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
    this.myUserDetailService = myUserDetailService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    final String authorizationHeader = request.getHeader("Authorization");
    String username = null;
    String jwt = null;

    if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      jwt = authorizationHeader.substring(7);
      username = jwtUtil.extractUsername(jwt);
    }

    if(username != null) {
      UserDetails userDetails = myUserDetailService.loadUserByUsername(username);

      if(jwtUtil.validateToken(jwt, userDetails)) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
            , null, userDetails.getAuthorities());
        SecurityContextHolder.getContext(). setAuthentication(authenticationToken);
      }
    }

    filterChain.doFilter(request, response);
  }

}
