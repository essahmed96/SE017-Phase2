package com.hellokoding.account.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role3")
public class Role3 {
    private Long id;
    private String name;
    private Set<Course> users;

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
    public Set<Course> getUsers() {
        return users;
    }

    public void setUsers(Set<Course> users) {
        this.users = users;
    }
}
