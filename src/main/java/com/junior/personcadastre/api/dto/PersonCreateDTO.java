package com.junior.personcadastre.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PersonCreate")
@Getter
@Setter
public class PersonCreateDTO extends ObjectBaseDTO {

    @ApiModelProperty(value = "First name")
    private String firstName;

    @ApiModelProperty(value = "Last name")
    private String lastName;

    @ApiModelProperty(value = "Person age")
    private int personAge;
}
