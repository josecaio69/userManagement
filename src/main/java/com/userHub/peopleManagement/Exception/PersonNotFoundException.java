package com.userHub.peopleManagement.Exception;

import java.util.UUID;

public class PersonNotFoundException  extends RuntimeException{
    private final String documentType;
    private final String documentValue;

    private static final String ID = "ID";
    private static final String PERSON_NOT_FOUND_MESSAGE = "Person not found with";

    public PersonNotFoundException(UUID id) {
        super(String.format(PERSON_NOT_FOUND_MESSAGE +" " + ID +" %d", id));
        this.documentType = ID;
        this.documentValue = String.valueOf(id);
    }

    public PersonNotFoundException(String documentType, String documentValue) {
        super(String.format(PERSON_NOT_FOUND_MESSAGE + " %s %s ", documentType, documentValue ));
        this.documentType = documentType;
        this.documentValue = documentValue;
    }

    public String getDocumentValue() {
        return documentValue;
    }

    public String getDocumentType() {
        return documentType;
    }
}
