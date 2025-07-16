package com.userHub.peopleManagement.service.impl;

import com.userHub.peopleManagement.dao.IndividualPersonRepository;
import com.userHub.peopleManagement.dao.LegalPersonRepository;
import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.model.IndividualPerson;
import com.userHub.peopleManagement.model.Person;
import com.userHub.peopleManagement.service.IndividualPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DefaultIndividualPersonService implements IndividualPersonService {
    private final IndividualPersonRepository individualPersonRepository;
    private final PersonMapper personMapper;

    @Autowired
    public DefaultIndividualPersonService(IndividualPersonRepository individualPersonRepository, LegalPersonRepository legalPersonRepository, PersonMapper personMapper) {
        this.individualPersonRepository = individualPersonRepository;
        this.personMapper = personMapper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Person createIndividualPerson(IndividualPersonDTO person) {
        IndividualPerson personModel = getPersonMapper().individualPersonToEntity(person);
        return getIndividualPersonRepository().save(personModel);
    }

    @Override
    public Person searchIndividualPersonById(Long id) {
        Optional<IndividualPerson> individualPerson = getIndividualPersonRepository().findById(id);

        return individualPerson.orElse(null);
    }

    @Override
    public Person searchIndividualPersonByCpf(String cpf) {
        Optional<IndividualPerson> individualPerson = getIndividualPersonRepository().findByCpf(cpf);

        return individualPerson.orElse(null);
    }

    @Override
    public Person updateIndividualPerson(IndividualPersonDTO person) {
        return this.createIndividualPerson(person);
    }

    @Override
    public void removeIndividualPerson(Long id) {
        getIndividualPersonRepository().deleteById(id);
    }

    public IndividualPersonRepository getIndividualPersonRepository() {
        return individualPersonRepository;
    }

    public PersonMapper getPersonMapper() {
        return personMapper;
    }
}
