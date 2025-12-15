package com.cafeteria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity<String> login() {
        // Basic auth handled by Spring Security, this is a stub endpoint
        return ResponseEntity.ok("Authenticated");
    }
}
