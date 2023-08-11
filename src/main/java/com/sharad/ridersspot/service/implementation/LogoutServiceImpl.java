package com.sharad.ridersspot.service.implementation;

import com.sharad.ridersspot.service.JwtService;
import com.sharad.ridersspot.service.LogoutService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {
    private final JwtService jwtService;
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String jwt;
        final String userEmail;

        Cookie[] cookies = request.getCookies();

        if(cookies == null) {
            return;
        }
        jwt = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals("token"))
                    .findFirst()
                    .map(Cookie::getValue)
                    .orElse(null);
        System.out.println("User with email " + jwtService.extractUsername(jwt) + " has logged out successfully.");
        SecurityContextHolder.clearContext();
    }
}
