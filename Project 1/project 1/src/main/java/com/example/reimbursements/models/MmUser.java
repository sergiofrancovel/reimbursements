package com.example.reimbursements.models;

import javax.persistence.*;

@Entity
@Table(name = "mm_user")
public class MmUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;


    @Column(name = "hash", nullable = false)
    private String hash;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private MmRole role;

    public MmUser() {

    }

    public MmRole getRole() {
        return role;
    }

    public void setRole(MmRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MmUser(String username, String hash, MmRole role, String email) {
        this.username = username;
        this.hash = hash;
        this.email = email;
        this.role = role;
    }


}