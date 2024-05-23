package com.example.internationchecklistbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FSHubController {

    @CrossOrigin(origins = "*")
    @PostMapping("/test")
    public ResponseEntity test (@RequestBody Map<String, Object> json){
        System.out.println("Received: ");
        System.out.println(json);

        return ResponseEntity.ok().build();
    }
}
