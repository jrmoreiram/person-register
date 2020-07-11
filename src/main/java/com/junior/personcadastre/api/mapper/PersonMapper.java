package com.junior.personcadastre.api.mapper;

import com.junior.personcadastre.api.dto.PersonCreateDTO;
import com.junior.personcadastre.api.dto.PersonDTO;
import com.junior.personcadastre.api.dto.PersonListDTO;
import com.junior.personcadastre.api.dto.PersonUpdateDTO;
import com.junior.personcadastre.domain.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

public class PersonMapper {

    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static PersonDTO fromEntity(Person person) {
        return mapper.map(person, PersonDTO.class);
    }

    public static Person fromCreateDTO(PersonCreateDTO dto) {
        return mapper.map(dto, Person.class);
    }

    public static PersonListDTO fromEntities(Page<Person> persons) {
        return new PersonListDTO(
                persons.getContent().stream()
                        .map(PersonMapper::fromEntity)
                        .collect(Collectors.toList()), persons.hasNext()
        );
    }

    public static Person fromUpdateDTO(int id, PersonUpdateDTO dto) {
        Person person = Person.PersonBuilder.of().id(id).build();

        mapper.map(dto, person);

        return person;
    }
}