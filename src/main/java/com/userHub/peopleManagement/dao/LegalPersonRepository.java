package com.userHub.peopleManagement.dao;

import com.userHub.peopleManagement.model.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LegalPersonRepository extends JpaRepository<LegalPerson, UUID> {
    Optional<LegalPerson> findByCnpj(String cnpj);

}
