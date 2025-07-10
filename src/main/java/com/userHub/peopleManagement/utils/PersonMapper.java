package com.userHub.peopleManagement.utils;

import com.userHub.peopleManagement.dto.IndividualPersonDTO;
import com.userHub.peopleManagement.dto.LegalPersonDTO;
import com.userHub.peopleManagement.model.IndividualPerson;
import com.userHub.peopleManagement.model.LegalPerson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    IndividualPersonDTO individualPersonToDto(IndividualPerson pessoa);
    LegalPersonDTO legalPersonPersonToDto(LegalPerson pessoa);

    IndividualPerson individualPersonToEntity(IndividualPersonDTO dto);
    LegalPerson legalPersonToEntity(LegalPersonDTO dto);
}
