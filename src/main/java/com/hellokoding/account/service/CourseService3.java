package com.hellokoding.account.service;



import com.hellokoding.account.model.Course;

public interface CourseService3 {
    void save(Course user);

    Course findByUsername(String username);
}
