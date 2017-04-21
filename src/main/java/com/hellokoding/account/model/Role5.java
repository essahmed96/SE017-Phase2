package com.hellokoding.account.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role5")
public class Role5 {
    private Long id;
    private String name;
    private Set<Tof> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<Tof> getUsers() {
        return users;
    }

    public void setUsers(Set<Tof> users) {
        this.users = users;
    }
}
