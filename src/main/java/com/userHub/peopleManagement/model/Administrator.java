package com.userHub.peopleManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userHub.peopleManagement.utils.Role;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "admin")
public class Administrator extends BaseUser{
    @Column
    @NotBlank
    private String userName;
    @Column
    @NotBlank
    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
