package com.example.web_250.models.out;
import com.example.web_250.models.entities.User;

public class UserOut {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer roleId; 
    private Integer isBanned;

    public UserOut(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roleId = user.getRoleId();
        this.isBanned = user.getIsBanned();
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
