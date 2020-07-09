package com.junior.personcadastre.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PersonCreate")
@Getter
@Setter
public class PersonCreateDTO extends ObjectBaseDTO {

    @ApiModelProperty(value = "Primeiro nome")
    private String firstName;

    @ApiModelProperty(value = "Último nome")
    private String lastName;

    @ApiModelProperty(value = "Idade da pessoa")
    private int personAge;

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getPersonAge() {
//        return personAge;
//    }
//
//    public void setPersonAge(int personAge) {
//        this.personAge = personAge;
//    }
}
