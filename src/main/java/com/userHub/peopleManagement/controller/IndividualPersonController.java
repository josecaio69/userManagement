package com.userHub.peopleManagement.controller;

import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.model.IndividualPerson;
import com.userHub.peopleManagement.service.IndividualPersonService;
import com.userHub.peopleManagement.service.impl.DefaultIndividualPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping(value = "/cpf/{cpf}")
    public IndividualPersonDTO getIndividualPersonByCpf(@PathVariable String cpf) {
        return this.personMapper.individualPersonToDto((IndividualPerson) personService.searchIndividualPersonByCpf(cpf));
    }

    @GetMapping(value = "/id/{id}")
    public IndividualPersonDTO getIndividualPersonById(@PathVariable Long id) {
        return this.personMapper.individualPersonToDto((IndividualPerson) personService.searchIndividualPersonById(id));
    }

    @PutMapping
    public IndividualPersonDTO updateIndividualPerson(@RequestBody IndividualPersonDTO personDTO){
        return this.personMapper.individualPersonToDto((IndividualPerson) personService.updateIndividualPerson(personDTO));
    }

    @DeleteMapping
    public void deleteIndividualPerson(@RequestBody Long id){
        this.personService.removeIndividualPerson(id);
    }
}
