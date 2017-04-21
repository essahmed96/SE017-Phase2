package com.hellokoding.account.service;





import com.hellokoding.account.model.Tof;

public interface TofService5 {
    void save(Tof user);

    Tof findByUsername(String username);
}
