package com.junior.personcadastre.api.param;

import io.swagger.annotations.ApiParam;

import java.util.List;

public class SortParam {

    @ApiParam(name = "direction", value = "Direction in which ordering will be applied")
    private String direction;

    @ApiParam(name = "persons", value = "Attributes for sorting")
    private List<String> persons;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<String> getPersons() {
        return persons;
    }

    public void setPersons(List<String> persons) {
        this.persons = persons;
    }

}