package com.javierhernandez.soccerfieldmanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javierhernandez.soccerfieldmanager.services.AuthService;

//Logs registros 

@RestController
@RequestMapping("soccerfield/v1/auth")//Para buscar la clasa es como una direccion para buscar un metodo en especifico (url general)
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(){
        
    }

}
