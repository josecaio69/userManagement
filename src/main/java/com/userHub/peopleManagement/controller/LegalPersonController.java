package com.userHub.peopleManagement.controller;

import com.userHub.peopleManagement.dto.LegalPersonDTO;
import com.userHub.peopleManagement.model.LegalPerson;
import com.userHub.peopleManagement.service.LegalPersonService;
import com.userHub.peopleManagement.service.impl.DefaultLegalPersonService;
import com.userHub.peopleManagement.utils.PersonMapper;
import io.swagger.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Legal Person", description = "Management of legal entities")
@RestController
@RequestMapping(value = "/legalPerson")
public class LegalPersonController {
    private static final String REGEX_VALIDATE_CNPJ = "\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}-\\d{2}";

    private final PersonMapper personMapper;
    private final LegalPersonService legalPersonService;

    @Autowired
    public LegalPersonController(PersonMapper personMapper, DefaultLegalPersonService legalPersonService) {
        this.personMapper = personMapper;
        this.legalPersonService = legalPersonService;
    }

    @Operation(summary = "Create New Legal Person")
    @PostMapping
    public LegalPersonDTO createNewIndividualPerson(@RequestBody
                                                    @Schema(description = "DTO With All Company Data") LegalPersonDTO personDTO) {
        return this.personMapper.legalPersonToDto((LegalPerson) legalPersonService.createOrUpdateLegalPerson(personDTO));
    }

    @Operation(summary = "Search for Legal Entity by CNPJ")
    @GetMapping(value = "/cnpj")
    public LegalPersonDTO getLegalPersonByCnpj(@RequestParam
                                               @Pattern(regexp = REGEX_VALIDATE_CNPJ, message = "Invalid CNPJ")
                                               @Schema(description = "Company CNPJ for carrying out the search") String cnpj) {
        return this.personMapper.legalPersonToDto((LegalPerson) legalPersonService.searchLegalPersonByCnpj(cnpj));
    }

    @Operation(summary = "Search for Legal Entity by ID")
    @GetMapping(value = "/id/{id}")
    public LegalPersonDTO getLegalPersonById(@PathVariable
                                             @Schema(description = "Company ID for carrying out the search") UUID id) {
        return this.personMapper.legalPersonToDto((LegalPerson) legalPersonService.searchLegalPersonById(id));
    }

    @Operation(summary = "Update data for a legal entity")
    @PutMapping
    public LegalPersonDTO updateLegalPerson(@RequestBody
                                            @Schema(description = "DTO With All Company Data To Update") LegalPersonDTO personDTO) {
        return this.personMapper.legalPersonToDto((LegalPerson) legalPersonService.createOrUpdateLegalPerson(personDTO));
    }

    @Operation(summary = "Remove a Legal Entity by its ID")
    @DeleteMapping
    public void deleteLegalPerson(@RequestBody
                                  @Schema(description = "Company ID for deletion") UUID id) {
        this.legalPersonService.removeLegalPersonPersonById(id);
    }
}
