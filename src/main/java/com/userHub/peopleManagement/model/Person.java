package com.userHub.peopleManagement.model;

import jakarta.persistence.*;


@MappedSuperclass
public class Person extends BaseUser{
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
