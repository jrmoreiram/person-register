package com.junior.personcadastre.api;

import com.junior.personcadastre.domain.Person;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record PersonDTO(@NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName, int personAge) {

    public Person toEntity() {
        return new Person(null, this.firstName, this.lastName, this.personAge);
    }
}
