package com.userHub.peopleManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "individual_person")
public class IndividualPerson extends Person {
    @Column(unique = true)
    @CPF
    private String cpf;
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    @Column
    private String rg;

    public @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotBlank LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
