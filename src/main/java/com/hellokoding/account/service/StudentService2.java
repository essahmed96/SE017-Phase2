package com.hellokoding.account.service;


import com.hellokoding.account.model.Student;

public interface StudentService2 {
    void save(Student user);

    Student findByUsername(String username);
}
