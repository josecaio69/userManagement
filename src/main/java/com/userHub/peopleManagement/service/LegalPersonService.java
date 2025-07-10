package com.userHub.peopleManagement.service;

import com.userHub.peopleManagement.dto.LegalPersonDTO;
import com.userHub.peopleManagement.model.Person;

public interface LegalPersonService {
    Person createLegalPerson(LegalPersonDTO person);
    Person updateLegalPerson(LegalPersonDTO person);
    Person searchLegalPersonById(Long id);
    Person searchLegalPersonByCnpj(String cnpj);
    void removeLegalPersonPersonById(Long id);
}
