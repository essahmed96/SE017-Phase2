package com.hellokoding.account.service;





import com.hellokoding.account.model.Game;


public interface GameService6 {
    void save(Game user);

    Game findByUsername(String username);
}
