package com.sharad.ridersspot.controller;

import com.sharad.ridersspot.collection.Credentials;
import com.sharad.ridersspot.collection.dto.UserDTO;
import com.sharad.ridersspot.exception.UserAlreadyExistsException;
import com.sharad.ridersspot.service.AuthenticationService;
import com.sharad.ridersspot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialNotFoundException;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    ResponseEntity<String> register(@RequestBody UserDTO userDTO) throws UserAlreadyExistsException {
        String token;
        HttpHeaders headers = new HttpHeaders();
        try {
            token = authenticationService.register(userDTO);
        } catch (UserAlreadyExistsException e) {
            headers.add("description", "User with this email already exists.");
            return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body("User with this email already exists.");
        }
        headers.add("description", "User has been registered successfully.");
        headers.add("Set-Cookie", "token="+token);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("User has been registered successfully.");
    }

    @PostMapping("/authenticate")
    ResponseEntity<String> authenticate(@RequestBody Credentials credentials) throws UsernameNotFoundException {
        String token;
        HttpHeaders headers = new HttpHeaders();
        try {
            token = authenticationService.authenticate(credentials);
        } catch (UsernameNotFoundException e) {
            headers.add("description", "User not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("User not found.");
        } catch (CredentialNotFoundException e){
            headers.add("description", "Invalid Credentials.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("Invalid Credentials.");
        }
        headers.add("description", "User has been authenticated successfully.");
        headers.add("Set-Cookie", "token="+token);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("User has been authenticated successfully.");
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

}
