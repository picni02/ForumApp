package com.example.web_250.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.example.web_250.models.in.UserIn;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 255)
    private String firstName;
    
    @Size(max = 255)
    private String lastName;

    @Size(max = 255)
    @Column(unique = true)
    private String email;

    @Size(max = 255)
    private String password;

    private Integer roleId;
    // 0 - korisnik, 1 - administrator
    private Integer isBanned;
    // 0 - nije banan, 1 - banan
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public User() {
    }

    public User(UserIn user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roleId = 0;
        this.isBanned = 0;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getIsBanned() {
        return this.isBanned;
    }

    public void setBanan(Integer isBanned) {
        this.isBanned = isBanned;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

}
