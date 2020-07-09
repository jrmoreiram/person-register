package com.junior.personcadastre.api.dto;

import io.swagger.annotations.ApiModel;

import java.util.Collection;

@ApiModel("PersonList")
public class PersonListDTO extends CollectionBaseDTO<PersonDTO> {
    public PersonListDTO(Collection<PersonDTO> persons, boolean hasNext) {
        super(persons, hasNext);
    }
}
