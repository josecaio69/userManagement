package com.userHub.peopleManagement.dao;

import com.userHub.peopleManagement.model.IndividualPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IndividualPersonRepository extends JpaRepository<IndividualPerson, UUID> {
    Optional<IndividualPerson> findByCpf(String cpf);
}
