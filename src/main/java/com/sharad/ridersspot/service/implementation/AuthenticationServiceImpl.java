package com.sharad.ridersspot.service.implementation;

import com.sharad.ridersspot.collection.Credentials;
import com.sharad.ridersspot.collection.Role;
import com.sharad.ridersspot.collection.User;
import com.sharad.ridersspot.collection.dto.UserDTO;
import com.sharad.ridersspot.collection.mapper.UserMapper;
import com.sharad.ridersspot.exception.UserAlreadyExistsException;
import com.sharad.ridersspot.repository.UserRepository;
import com.sharad.ridersspot.service.AuthenticationService;
import com.sharad.ridersspot.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialNotFoundException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserMapper userMapper;
    @Override
    public String register(UserDTO userDTO) throws UserAlreadyExistsException {
        if(userRepository.existsById(userDTO.getId()) || userRepository.existsByEmail(userDTO.getEmail()))
            throw new UserAlreadyExistsException("User with this email is already registered.");

        User user = User
                        .builder()
                        .id(userDTO.getId())
                        .name(userDTO.getName())
                        .email(userDTO.getEmail())
                        .password(passwordEncoder.encode(userDTO.getPassword()))
                        .role(Role.USER).build();

        userRepository.insert(user);
        String jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }

    @Override
    public String authenticate(Credentials credentials) throws UsernameNotFoundException, CredentialNotFoundException {
        if(!userRepository.existsByEmail(credentials.getEmail()))
            throw new UsernameNotFoundException("User not found");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getEmail(),
                            credentials.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new CredentialNotFoundException("Invalid Credentials");
        }

        User user = userRepository.findByEmail(credentials.getEmail()).get();
        String jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }
}
