package com.javierhernandez.soccerfieldmanager.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.javierhernandez.soccerfieldmanager.models.User;
import com.j

public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Override
    public User save(User user){
        return authRepository.save(user);
    }
}
