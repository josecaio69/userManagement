package com.userHub.peopleManagement.service;

import com.userHub.peopleManagement.dto.LegalPersonDTO;
import com.userHub.peopleManagement.model.Person;

import java.util.UUID;

public interface LegalPersonService {
    Person createOrUpdateLegalPerson(LegalPersonDTO person);
    Person searchLegalPersonById(UUID id);
    Person searchLegalPersonByCnpj(String cnpj);
    void removeLegalPersonPersonById(UUID id);
}
