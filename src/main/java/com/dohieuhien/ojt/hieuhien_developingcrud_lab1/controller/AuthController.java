package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.controller;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.config.JwtUtils;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.config.UserPrincipal;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.dto.LoginRequest;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.dto.LoginRespond;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hien/auth")
@RequiredArgsConstructor

public class AuthController {

    private final AuthenticationManager manager;
    private final JwtUtils jwtUtils;

    @PostMapping("/")
    public ResponseEntity<LoginRespond> login (@Valid @RequestBody LoginRequest request){
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        String token = jwtUtils.generateToken(principal);
        String role = principal.getUser().getRole().getRoleName();

        return ResponseEntity.ok(new LoginRespond(token, principal.getUsername(), role));
    }


}
