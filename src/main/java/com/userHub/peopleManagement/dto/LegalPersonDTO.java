package com.userHub.peopleManagement.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class LegalPersonDTO extends PersonDTO{

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String companyName;
    @NotBlank
    private LocalDate foundationDate;

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank String phone) {
        this.phone = phone;
    }

    public @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotBlank String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@NotBlank String companyName) {
        this.companyName = companyName;
    }

    public @NotBlank LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(@NotBlank LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }
}
