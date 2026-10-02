package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.controller;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.config.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/hien/dashboard")
public class DashboardController {

    @GetMapping("/name")
    public Map<String, String> name(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return Map.of("username", userPrincipal.getUsername(),
                "role", userPrincipal.getUser().getRole().getRoleName());
    }
}
