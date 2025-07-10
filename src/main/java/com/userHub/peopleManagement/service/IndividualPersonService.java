package com.userHub.peopleManagement.service;

import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.model.Person;

public interface IndividualPersonService {

    Person createIndividualPerson(IndividualPersonDTO person);
    Person updateIndividualPerson(IndividualPersonDTO person);
    Person searchIndividualPersonById(Long id);
    Person searchIndividualPersonByCpf(String cpf);
    void removeIndividualPerson(Long id);
}
