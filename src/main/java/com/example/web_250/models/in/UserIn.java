package com.example.web_250.models.in;

import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

public class UserIn {
    @Nullable
    private Integer id;

    @Size(max = 255)
    private String firstName;
    
    @Size(max = 255)
    private String lastName;

    @Size(max = 255)
    private String email;

    @Size(max = 255)
    private String password;

    private Integer roleId; 
    // 0 - korisnik, 1 - administrator
    private Integer isBanned;
    // 0 - nije banan, 1 - banan
    
    public UserIn() {
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

    public void setIsBanned(Integer isBanned) {
        this.isBanned = isBanned;
    }

}
