package com.userHub.peopleManagement.service.impl;

import com.userHub.peopleManagement.Exception.PersonNotFoundException;
import com.userHub.peopleManagement.dao.IndividualPersonRepository;
import com.userHub.peopleManagement.dao.LegalPersonRepository;
import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.model.IndividualPerson;
import com.userHub.peopleManagement.model.Person;
import com.userHub.peopleManagement.service.IndividualPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DefaultIndividualPersonService implements IndividualPersonService {
    private static final String CPF = "CPF";
    private final IndividualPersonRepository individualPersonRepository;
    private final PersonMapper personMapper;

    @Autowired
    public DefaultIndividualPersonService(IndividualPersonRepository individualPersonRepository, LegalPersonRepository legalPersonRepository, PersonMapper personMapper) {
        this.individualPersonRepository = individualPersonRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Person createOrUpdateIndividualPerson(IndividualPersonDTO person) {
        IndividualPerson personModel = getPersonMapper().individualPersonToEntity(person);

        Optional<IndividualPerson> individualPersonToUpdate = getIndividualPersonRepository().findByCpf(Optional.ofNullable(person.getCpf()).orElse(""));

        individualPersonToUpdate.ifPresent(legalPerson -> personModel.setId(legalPerson.getId()));

        return getIndividualPersonRepository().save(personModel);
    }

    @Override
    public Person searchIndividualPersonById(Long id) {
        return getIndividualPersonRepository()
                .findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public Person searchIndividualPersonByCpf(String cpf) {
        return getIndividualPersonRepository()
                .findByCpf(cpf)
                .orElseThrow(() -> new PersonNotFoundException(CPF, cpf));
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
