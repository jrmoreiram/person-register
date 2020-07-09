package com.junior.personcadastre.mapper;

import com.junior.personcadastre.api.PersonDTO;
import com.junior.personcadastre.api.PersonListDTO;
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

    public static Person fromCreateDTO(PersonDTO dto) {
        return mapper.map(dto, Person.class);
    }

    public static PersonListDTO fromEntities(Page<Person> persons) {
        return new PersonListDTO(
                persons.getContent().stream()
                        .map(PersonMapper::fromEntity)
                        .collect(Collectors.toList()), persons.hasNext()
        );
    }
}
