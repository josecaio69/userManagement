package com.userHub.peopleManagement.controller;

import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.model.IndividualPerson;
import com.userHub.peopleManagement.service.IndividualPersonService;
import com.userHub.peopleManagement.service.impl.DefaultIndividualPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import io.swagger.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Individual Person", description = "Management of Individuals")
@RestController
@RequestMapping(value = "/individualPerson")
public class IndividualPersonController {
    private final PersonMapper personMapper;
    private final IndividualPersonService personService;

    @Autowired
    public IndividualPersonController(PersonMapper personMapper, DefaultIndividualPersonService personService) {
        this.personMapper = personMapper;
        this.personService = personService;
    }

    @Operation(summary = "Create New Individual Person")
    @PostMapping
    public IndividualPersonDTO createNewIndividualPerson(@RequestBody
                                                         @Schema(description = "DTO with All Data of an Individual") IndividualPersonDTO personDTO) {
        return this.personMapper.individualPersonToDto((IndividualPerson) personService.createOrUpdateIndividualPerson(personDTO));
    }

    @Operation(summary = "Search for Individual Person by CPF")
    @GetMapping(value = "/cpf/{cpf}")
    public IndividualPersonDTO getIndividualPersonByCpf(@PathVariable
                                                        @Schema(description = "CPF of the person to carry out the search") String cpf) {
        return this.personMapper.individualPersonToDto((IndividualPerson) personService.searchIndividualPersonByCpf(cpf));
    }

    @Operation(summary = "Search for Individual Person by ID")
    @GetMapping(value = "/id/{id}")
    public IndividualPersonDTO getIndividualPersonById(@PathVariable
                                                       @Schema(description = "ID of the person to carry out the search") Long id) {
        return this.personMapper.individualPersonToDto((IndividualPerson) personService.searchIndividualPersonById(id));
    }

    @Operation(summary = "Update Individual Data")
    @PutMapping
    public IndividualPersonDTO updateIndividualPerson(@RequestBody
                                                      @Schema(description = "DTO With All Individual Person Data To Update") IndividualPersonDTO personDTO) {
        return this.personMapper.individualPersonToDto((IndividualPerson) personService.createOrUpdateIndividualPerson(personDTO));
    }

    @Operation(summary = "Remove a Individual Person by its ID")
    @DeleteMapping
    public void deleteIndividualPerson(@RequestBody Long id) {
        this.personService.removeIndividualPerson(id);
    }
}
