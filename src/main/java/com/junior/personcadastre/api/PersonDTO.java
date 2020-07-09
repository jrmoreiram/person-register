package com.junior.personcadastre.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("PersonResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO extends ObjectBaseDTO {
    @ApiModelProperty(value = "Identificador único")
    private String personId;

    @ApiModelProperty(value = "Primeiro nome")
    private String firstName;

    @ApiModelProperty(value = "Último nome")
    private String lastName;

    @ApiModelProperty(value = "Idade da pessoa")
    private int personAge;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }
}
