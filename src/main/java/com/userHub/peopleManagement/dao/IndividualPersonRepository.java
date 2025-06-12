package com.userHub.peopleManagement.dao;

import com.userHub.peopleManagement.model.IndividualPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualPersonRepository extends JpaRepository<IndividualPerson, Long> {
}
