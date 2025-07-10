package com.userHub.peopleManagement.service.impl;

import com.userHub.peopleManagement.dao.LegalPersonRepository;
import com.userHub.peopleManagement.dto.LegalPersonDTO;
import com.userHub.peopleManagement.model.LegalPerson;
import com.userHub.peopleManagement.model.Person;
import com.userHub.peopleManagement.service.LegalPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultLegalPersonService implements LegalPersonService {
    private  final LegalPersonRepository legalPersonRepository;
    private final PersonMapper personMapper;

    @Autowired
    public DefaultLegalPersonService(LegalPersonRepository legalPersonRepository, PersonMapper personMapper) {
        this.legalPersonRepository = legalPersonRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Person createLegalPerson(LegalPersonDTO person) {
        LegalPerson personModel = getPersonMapper().legalPersonToEntity(person);
        return getLegalPersonRepository().save(personModel);
    }

    @Override
    public Person updateLegalPerson(LegalPersonDTO person) {
        return this.createLegalPerson(person);
    }

    @Override
    public Person searchLegalPersonById(Long id) {
        Optional<LegalPerson> legalPerson = getLegalPersonRepository().findById(id);

        return legalPerson.orElse(null);
    }

    @Override
    public Person searchLegalPersonByCnpj(String cnpj) {
        Optional<LegalPerson> legalPerson = getLegalPersonRepository().findByCnpj(cnpj);

        return legalPerson.orElse(null);
    }

    @Override
    public void removeLegalPersonPersonById(Long id) {
        getLegalPersonRepository().deleteById(id);
    }

    public LegalPersonRepository getLegalPersonRepository() {
        return legalPersonRepository;
    }

    public PersonMapper getPersonMapper() {
        return personMapper;
    }
}
