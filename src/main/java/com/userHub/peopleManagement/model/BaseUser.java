package com.userHub.peopleManagement.model;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseUser {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
