package com.userHub.peopleManagement.service.impl;

import com.userHub.peopleManagement.dao.IndividualPersonRepository;
import com.userHub.peopleManagement.dao.LegalPersonRepository;
import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.dto.LegalPersonDTO;
import com.userHub.peopleManagement.dto.PersonDTO;
import com.userHub.peopleManagement.model.IndividualPerson;
import com.userHub.peopleManagement.model.LegalPerson;
import com.userHub.peopleManagement.model.Person;
import com.userHub.peopleManagement.service.PersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPersonService implements PersonService {
    private final IndividualPersonRepository individualPersonRepository;
    private final LegalPersonRepository legalPersonRepository;
    private final PersonMapper personMapper;

    @Autowired
    public DefaultPersonService(IndividualPersonRepository individualPersonRepository, LegalPersonRepository legalPersonRepository, PersonMapper personMapper) {
        this.individualPersonRepository = individualPersonRepository;
        this.legalPersonRepository = legalPersonRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Person createPerson(PersonDTO person) {

        if (person instanceof IndividualPersonDTO individualPerson) {
            IndividualPerson personModel = getPersonMapper().individualPersonToEntity(individualPerson);
            return getIndividualPersonRepository().save(personModel);
        }

        LegalPerson legalPerson = getPersonMapper().legalPersonToEntity((LegalPersonDTO) person);
        return getLegalPersonRepository().save(legalPerson);
    }

    @Override
    public Person updatePerson(PersonDTO person) {
        return this.createPerson(person);
    }

    @Override
    public Person searchPerson(PersonDTO person) {
        return null;
    }

    @Override
    public Person removePerson(PersonDTO person) {
        return null;
    }

    public IndividualPersonRepository getIndividualPersonRepository() {
        return individualPersonRepository;
    }


    public LegalPersonRepository getLegalPersonRepository() {
        return legalPersonRepository;
    }

    public PersonMapper getPersonMapper() {
        return personMapper;
    }
}
