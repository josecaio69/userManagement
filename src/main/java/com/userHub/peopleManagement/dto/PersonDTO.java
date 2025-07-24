package com.userHub.peopleManagement.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


public abstract class PersonDTO {
    @NotBlank
    private UUID id;
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String phone;

    public @NotBlank UUID getId() {
        return id;
    }

    public void setId(@NotBlank UUID id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @Email @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank String phone) {
        this.phone = phone;
    }
}
