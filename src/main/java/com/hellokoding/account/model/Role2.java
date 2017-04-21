package com.hellokoding.account.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role2 {
    private Long id;
    private String name;
    private Set<Student> users;

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
    public Set<Student> getUsers() {
        return users;
    }

    public void setUsers(Set<Student> users) {
        this.users = users;
    }
}
