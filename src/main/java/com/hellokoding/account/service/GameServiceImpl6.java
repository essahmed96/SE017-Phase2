package com.hellokoding.account.service;





import com.hellokoding.account.model.Game;

import com.hellokoding.account.repository.GameRepository6;

import com.hellokoding.account.repository.RoleRepository6;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class GameServiceImpl6 implements GameService6 {
    @Autowired
    private GameRepository6 userRepository6;
    @Autowired
    private RoleRepository6 roleRepository6;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Game user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository6.findAll()));
        userRepository6.save(user);
    }

    @Override
    public Game findByUsername(String username) {
        return userRepository6.findByUsername(username);
    }
}
