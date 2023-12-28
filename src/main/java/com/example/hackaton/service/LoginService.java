package com.example.hackaton.service;


import com.example.hackaton.entity.User;
import com.example.hackaton.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;



}