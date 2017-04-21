package com.hellokoding.account.service;




import com.hellokoding.account.model.Choesquestion;

public interface ChoesquestionService4 {
    void save(Choesquestion user);

    Choesquestion findByUsername(String username);
}
