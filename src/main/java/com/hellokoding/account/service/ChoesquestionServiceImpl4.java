package com.hellokoding.account.service;




import com.hellokoding.account.model.Choesquestion;

import com.hellokoding.account.repository.RoleRepository4;

import com.hellokoding.account.repository.ChoesquestionRepository4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ChoesquestionServiceImpl4 implements ChoesquestionService4 {
    @Autowired
    private ChoesquestionRepository4 userRepository4;
    @Autowired
    private RoleRepository4 roleRepository4;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Choesquestion user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository4.findAll()));
        userRepository4.save(user);
    }

    @Override
    public Choesquestion findByUsername(String username) {
        return userRepository4.findByUsername(username);
    }
}
