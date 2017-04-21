package com.hellokoding.account.repository;


import com.hellokoding.account.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository2 extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
}
