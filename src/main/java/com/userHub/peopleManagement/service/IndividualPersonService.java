package com.userHub.peopleManagement.service;

import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.model.Person;

import java.util.UUID;

public interface IndividualPersonService {

    Person createOrUpdateIndividualPerson(IndividualPersonDTO person);
    Person searchIndividualPersonById(UUID id);
    Person searchIndividualPersonByCpf(String cpf);
    void removeIndividualPerson(UUID id);
}
