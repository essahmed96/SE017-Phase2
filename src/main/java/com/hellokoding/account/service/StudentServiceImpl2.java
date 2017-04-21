package com.hellokoding.account.service;


import com.hellokoding.account.model.Student;

import com.hellokoding.account.repository.RoleRepository2;

import com.hellokoding.account.repository.StudentRepository2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class StudentServiceImpl2 implements StudentService2 {
    @Autowired
    private StudentRepository2 userRepository2;
    @Autowired
    private RoleRepository2 roleRepository2;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Student user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository2.findAll()));
        userRepository2.save(user);
    }

    @Override
    public Student findByUsername(String username) {
        return userRepository2.findByUsername(username);
    }
}
