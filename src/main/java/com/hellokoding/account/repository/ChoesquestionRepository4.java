package com.hellokoding.account.repository;




import com.hellokoding.account.model.Choesquestion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoesquestionRepository4 extends JpaRepository<Choesquestion, Long> {
    Choesquestion findByUsername(String username);
}
