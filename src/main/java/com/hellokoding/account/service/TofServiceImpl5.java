package com.hellokoding.account.service;





import com.hellokoding.account.model.Tof;

import com.hellokoding.account.repository.RoleRepository5;

import com.hellokoding.account.repository.TofRepository5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class TofServiceImpl5 implements TofService5 {
    @Autowired
    private TofRepository5 userRepository5;
    @Autowired
    private RoleRepository5 roleRepository5;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Tof user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository5.findAll()));
        userRepository5.save(user);
    }

    @Override
    public Tof findByUsername(String username) {
        return userRepository5.findByUsername(username);
    }
}
