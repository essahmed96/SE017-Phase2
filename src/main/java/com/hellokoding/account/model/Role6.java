package com.hellokoding.account.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role6")
public class Role6 {
    private Long id;
    private String name;
    private Set<Game> users;

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
    public Set<Game> getUsers() {
        return users;
    }

    public void setUsers(Set<Game> users) {
        this.users = users;
    }
}
