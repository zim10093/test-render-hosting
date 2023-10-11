package com.example.renderdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class Controller {

    @Value("${app.varible.test}")
    private String variable;


    @GetMapping
    public ResponseEntity<?> createUser() {
        return ResponseEntity.ok(variable + " " + System.currentTimeMillis());
    }


}
