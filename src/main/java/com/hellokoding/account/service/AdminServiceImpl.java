package com.hellokoding.account.service;

import com.hellokoding.account.model.Admin;
import com.hellokoding.account.repository.RoleRepository;
import com.hellokoding.account.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Admin user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public Admin findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
