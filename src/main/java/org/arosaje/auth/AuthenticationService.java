package org.arosaje.auth;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.arosaje.auth.AuthenticationRequest;
import org.arosaje.auth.AuthenticationResponse;
import org.arosaje.auth.RegisterRequest;
import org.arosaje.config.JwtService;
import org.arosaje.entities.Roles;
import org.arosaje.entities.User;
import org.arosaje.entities.UserInfo;
import org.arosaje.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .userInfo(new UserInfo(request.getFirstname(),request.getLastname()))
                .email(request.getEmail())
                .pwd(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .roles(Roles.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       request.getEmail(),
                       request.getPassword()
               )
       );

       var user = userRepository.findByEmail(request.getEmail())
                       .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }



}
