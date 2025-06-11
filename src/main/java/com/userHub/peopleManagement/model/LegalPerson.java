package com.userHub.peopleManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "legal_person")
public class LegalPerson extends Person {
    @Column
    private String cnpj;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "foundation_date")
    private LocalDate foundationDate;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }
}
