package com.userHub.peopleManagement.dao;

import com.userHub.peopleManagement.model.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalPersonRepository extends JpaRepository<LegalPerson, Long> {
}
