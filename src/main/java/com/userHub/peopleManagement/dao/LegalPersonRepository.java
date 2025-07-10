package com.userHub.peopleManagement.dao;

import com.userHub.peopleManagement.model.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LegalPersonRepository extends JpaRepository<LegalPerson, Long> {
    Optional<LegalPerson> findByCnpj(String cnpj);

}
