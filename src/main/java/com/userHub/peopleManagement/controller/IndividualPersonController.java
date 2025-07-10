package com.userHub.peopleManagement.controller;

import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.model.IndividualPerson;
import com.userHub.peopleManagement.service.IndividualPersonService;
import com.userHub.peopleManagement.service.impl.DefaultIndividualPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/individualPerson")
public class IndividualPersonController {
    private final PersonMapper personMapper;
    private final IndividualPersonService personService;

    @Autowired
    public IndividualPersonController (PersonMapper personMapper, DefaultIndividualPersonService personService){
        this.personMapper = personMapper;
        this.personService = personService;
    }

    @PostMapping
    public IndividualPersonDTO createNewIndividualPerson(@RequestBody IndividualPersonDTO personDTO){
        return this.personMapper.individualPersonToDto((IndividualPerson) personService.createIndividualPerson(personDTO));
    }
}
