package com.userHub.peopleManagement.service.impl;

import com.userHub.peopleManagement.Exception.PersonNotFoundException;
import com.userHub.peopleManagement.dao.LegalPersonRepository;
import com.userHub.peopleManagement.dto.LegalPersonDTO;
import com.userHub.peopleManagement.model.LegalPerson;
import com.userHub.peopleManagement.model.Person;
import com.userHub.peopleManagement.service.LegalPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class DefaultLegalPersonService implements LegalPersonService {
    private static final String CNPJ = "CNPJ";

    private final LegalPersonRepository legalPersonRepository;
    private final PersonMapper personMapper;

    @Autowired
    public DefaultLegalPersonService(LegalPersonRepository legalPersonRepository, PersonMapper personMapper) {
        this.legalPersonRepository = legalPersonRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Person createOrUpdateLegalPerson(LegalPersonDTO person) {
        LegalPerson newLegalPerson = getPersonMapper().legalPersonToEntity(person);
        Optional<LegalPerson> legalPersonToUpdate = getLegalPersonRepository().findByCnpj(Optional.ofNullable(person.getCnpj()).orElse(""));

        legalPersonToUpdate.ifPresent(legalPerson -> newLegalPerson.setId(legalPerson.getId()));

        return getLegalPersonRepository().save(newLegalPerson);
    }

    @Override
    public Person searchLegalPersonById(UUID id) {
        return getLegalPersonRepository()
                .findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public Person searchLegalPersonByCnpj(String cnpj) {
        return getLegalPersonRepository()
                .findByCnpj(cnpj)
                .orElseThrow(() -> new PersonNotFoundException(CNPJ, cnpj));
    }

    @Override
    public void removeLegalPersonPersonById(UUID id) {
        getLegalPersonRepository().deleteById(id);
    }

    public LegalPersonRepository getLegalPersonRepository() {
        return legalPersonRepository;
    }

    public PersonMapper getPersonMapper() {
        return personMapper;
    }
}
