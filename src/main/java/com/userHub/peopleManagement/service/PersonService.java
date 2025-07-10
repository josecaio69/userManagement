package com.userHub.peopleManagement.service;

import com.userHub.peopleManagement.dto.PersonDTO;
import com.userHub.peopleManagement.model.Person;

public interface PersonService {

    Person createPerson(PersonDTO person);
    Person updatePerson(PersonDTO person);
    Person searchPerson(PersonDTO person);
    Person removePerson(PersonDTO person);
}
