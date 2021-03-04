package com.itspace.job.config.security.filter;

import com.itspace.job.model.User;
import com.itspace.job.model.UserRole;
import com.itspace.job.repository.UserRepository;
import com.itspace.job.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationFilter extends GenericFilter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("Authorization");

        if (token != null) {
            Claims claims = jwtUtil.parseToken(token);
            String email = (String) claims.get("sub");
            if (email != null) {
                User byEmail = userRepository.findByEmail(email);
                if (byEmail != null) {
                    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    for (UserRole userRole : byEmail.getUserRoles()) {
                        authorities.add(new SimpleGrantedAuthority(userRole.getName()));
                    }
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(byEmail, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
