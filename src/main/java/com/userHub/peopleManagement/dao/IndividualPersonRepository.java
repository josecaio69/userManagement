package com.userHub.peopleManagement.dao;

import com.userHub.peopleManagement.model.IndividualPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndividualPersonRepository extends JpaRepository<IndividualPerson, Long> {
    Optional<IndividualPerson> findByCpf(String cpf);
}
