package com.hellokoding.account.service;



import com.hellokoding.account.model.Course;


import com.hellokoding.account.repository.RoleRepository3;


import com.hellokoding.account.repository.CourseRepository3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CourseServiceImpl3 implements CourseService3 {
    @Autowired
    private CourseRepository3 userRepository3;
    @Autowired
    private RoleRepository3 roleRepository3;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Course user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository3.findAll()));
        userRepository3.save(user);
    }

    @Override
    public Course findByUsername(String username) {
        return userRepository3.findByUsername(username);
    }
}
