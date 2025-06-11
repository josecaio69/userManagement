package com.userHub.peopleManagement.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class IndividualPersonDTO  extends PersonDTO{
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String cpf;
    @NotBlank
    private LocalDate birthDate;
    @NotBlank
    private String rg;

    public @NotBlank String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank String phone) {
        this.phone = phone;
    }

    public @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotBlank LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @NotBlank String getRg() {
        return rg;
    }

    public void setRg(@NotBlank String rg) {
        this.rg = rg;
    }
}
