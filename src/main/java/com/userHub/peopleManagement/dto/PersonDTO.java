package com.userHub.peopleManagement.dto;

import javax.validation.constraints.NotBlank;

public abstract class PersonDTO {
    @NotBlank
    private Long id;
    @NotBlank
    private String name;

    public @NotBlank Long getId() {
        return id;
    }

    public void setId(@NotBlank Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }
}
