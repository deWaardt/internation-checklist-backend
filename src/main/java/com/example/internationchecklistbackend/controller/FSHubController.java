package com.example.internationchecklistbackend.controller;

import com.fasterxml.jackson.databind.JsonNode;
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
    public ResponseEntity test (@RequestBody JsonNode jsonNode){
        System.out.println("Received: ");
        //System.out.println(json);

        System.out.println(jsonNode.get("_data"));

        return ResponseEntity.ok().build();
    }
}
