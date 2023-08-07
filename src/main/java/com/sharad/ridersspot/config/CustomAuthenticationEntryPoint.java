package com.sharad.ridersspot.config;

import org.json.simple.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        JSONObject body = new JSONObject();

        final String message = (String) request.getAttribute("message");
        body.put("status", 403);
        body.put("message", (message != null) ? message : "Access denied");

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(403);
        response.getWriter().write(body.toJSONString());
    }
}