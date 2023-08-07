package com.sharad.ridersspot.service;

import com.sharad.ridersspot.collection.Credentials;
import com.sharad.ridersspot.collection.dto.UserDTO;
import com.sharad.ridersspot.exception.UserAlreadyExistsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.security.auth.login.CredentialNotFoundException;

public interface AuthenticationService {
    public String register(UserDTO userDTO) throws UserAlreadyExistsException;
    public String authenticate(Credentials credentials) throws UsernameNotFoundException, CredentialNotFoundException;
}
