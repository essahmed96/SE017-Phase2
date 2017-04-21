package com.hellokoding.account.repository;





import com.hellokoding.account.model.Game;


import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository6 extends JpaRepository<Game, Long> {
	Game findByUsername(String username);
}
