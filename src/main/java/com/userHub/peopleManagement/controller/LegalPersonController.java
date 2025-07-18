package com.userHub.peopleManagement.controller;

import com.userHub.peopleManagement.dto.LegalPersonDTO;
import com.userHub.peopleManagement.model.LegalPerson;
import com.userHub.peopleManagement.service.LegalPersonService;
import com.userHub.peopleManagement.service.impl.DefaultLegalPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/legalPerson")
public class LegalPersonController {
    private final PersonMapper personMapper;
    private final LegalPersonService legalPersonService;

    @Autowired
    public LegalPersonController(PersonMapper personMapper, DefaultLegalPersonService legalPersonService) {
        this.personMapper = personMapper;
        this.legalPersonService = legalPersonService;
    }

    @PostMapping
    public LegalPersonDTO createNewIndividualPerson(@RequestBody LegalPersonDTO personDTO){
        return this.personMapper.legalPersonToDto((LegalPerson) legalPersonService.createLegalPerson(personDTO));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public LegalPersonDTO getLegalPersonByCpf(@PathVariable String cnpj) {
        return this.personMapper.legalPersonToDto((LegalPerson) legalPersonService.searchLegalPersonByCnpj(cnpj));
    }

    @GetMapping(value = "/id/{id}")
    public LegalPersonDTO getLegalPersonById(@PathVariable Long id) {
        return this.personMapper.legalPersonToDto((LegalPerson) legalPersonService.searchLegalPersonById(id));
    }

    @PutMapping
    public LegalPersonDTO updateLegalPerson(@RequestBody LegalPersonDTO personDTO){
        return this.personMapper.legalPersonToDto((LegalPerson) legalPersonService.updateLegalPerson(personDTO));
    }

    @DeleteMapping
    public void deleteLegalPerson(@RequestBody Long id){
        this.legalPersonService.removeLegalPersonPersonById(id);
    }
}
