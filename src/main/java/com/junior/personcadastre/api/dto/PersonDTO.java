package com.junior.personcadastre.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PersonResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PersonDTO extends ObjectBaseDTO {

    @ApiModelProperty(value = "Unique identifier")
    private int id;

    @ApiModelProperty(value = "First name")
    private String firstName;

    @ApiModelProperty(value = "Last name")
    private String lastName;

    @ApiModelProperty(value = "Person age")
    private int personAge;
}
