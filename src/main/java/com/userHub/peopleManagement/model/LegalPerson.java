package com.userHub.peopleManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "legal_person")
public class LegalPerson extends Person {
    @NotBlank
    private String cnpj;
    @NotBlank
    private String companyName;
    @NotBlank
    private LocalDate foundationDate;

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
