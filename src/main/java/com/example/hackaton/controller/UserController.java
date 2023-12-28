package com.example.hackaton.controller;


import com.example.hackaton.entity.User;
import com.example.hackaton.repository.UserRepository;
import com.example.hackaton.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String name,
                                        @RequestParam String email,
                                        @RequestParam int googleId,
                                        HttpServletRequest request) {

        User user = new User(email, name, googleId);
        userRepository.save(user);

        return ResponseEntity.ok("로그인성공");
    }
}
