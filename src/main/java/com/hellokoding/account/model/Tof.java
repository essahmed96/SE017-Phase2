package com.hellokoding.account.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user5")
public class Tof {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<Role5> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role5", joinColumns = @JoinColumn(name = "user_id5"), inverseJoinColumns = @JoinColumn(name = "role_id5"))
    public Set<Role5> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role5> roles) {
        this.roles = roles;
    }
}
