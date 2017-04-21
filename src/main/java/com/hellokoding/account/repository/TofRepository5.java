package com.hellokoding.account.repository;





import com.hellokoding.account.model.Tof;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TofRepository5 extends JpaRepository<Tof, Long> {
    Tof findByUsername(String username);
}
