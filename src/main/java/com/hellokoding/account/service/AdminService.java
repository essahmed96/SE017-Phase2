package com.hellokoding.account.service;

import com.hellokoding.account.model.Admin;

public interface AdminService {
    void save(Admin user);

    Admin findByUsername(String username);
}
