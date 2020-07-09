package com.junior.personcadastre.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PersonUpdate")
@Getter
@Setter
public class PersonUpdateDTO extends ObjectBaseDTO {

    @ApiModelProperty(value = "Primeiro nome")
    private String firstName;

    @ApiModelProperty(value = "Último nome")
    private String lastName;

    @ApiModelProperty(value = "Idade da pessoa")
    private int personAge;
}
