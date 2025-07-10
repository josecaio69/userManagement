package com.userHub.peopleManagement.controller;

import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.model.IndividualPerson;
import com.userHub.peopleManagement.service.impl.DefaultPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class IndividualPersonController {
    private final PersonMapper personMapper;
    private final DefaultPersonService personService;

    @Autowired
    public IndividualPersonController (PersonMapper personMapper, DefaultPersonService personService){
        this.personMapper = personMapper;
        this.personService = personService;
    }

    @PostMapping("/individualPerson")
    public IndividualPersonDTO createNewIndividualPerson(@RequestBody IndividualPersonDTO personDTO){
        return this.personMapper.individualPersonToDto((IndividualPerson) personService.createPerson(personDTO));
    }
}
