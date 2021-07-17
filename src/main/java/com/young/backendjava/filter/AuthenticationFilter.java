package com.young.backendjava.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.young.backendjava.SpringApplicationContext;
import com.young.backendjava.constant.SecurityConstant;
import com.young.backendjava.model.request.UserLoginRequestModel;
import com.young.backendjava.service.UserService;
import com.young.backendjava.shared.dto.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RequiredArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        try {
            UserLoginRequestModel userModel = new ObjectMapper()
                    .readValue(request.getInputStream(), UserLoginRequestModel.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userModel.getEmail(),
                            userModel.getPassword(),
                            new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        String username = ((User) authResult.getPrincipal()).getUsername(); // username == email
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_DATE))
                .signWith(SignatureAlgorithm.HS512, SecurityConstant.getTokenSecret())
                .compact();
        UserService userService = (UserService) SpringApplicationContext.getBean("userService");
        UserDto userDto = userService.getUser(username);

        response.addHeader("Access-Control-Expose-Headers", "Authorization, UserId");
        response.addHeader("UserId", userDto.getUserId());
        response.addHeader(SecurityConstant.AUTH_HEADER, SecurityConstant.TOKEN_PREFIX + token);
    }
}
