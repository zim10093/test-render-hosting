package com.example.renderdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserRepository repository;

    @GetMapping
    public ResponseEntity<?> createUser() {
        UserEntity user = new UserEntity();
        user.setName("time " + System.currentTimeMillis());
        repository.save(user);
        List<UserEntity> all = repository.findAll();
        return ResponseEntity.ok(all.stream().map(UserEntity::getName).collect(Collectors.joining("; ")));
    }


}
