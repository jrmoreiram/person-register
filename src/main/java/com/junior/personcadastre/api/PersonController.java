package com.junior.personcadastre.api;

import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.repository.PersonRepository;
import com.junior.personcadastre.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    private PersonService personService;

    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @GetMapping
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody @Valid PersonDTO person) {
        Person personEntity = personService.savePerson(person.toEntity());
        return new ResponseEntity<>(personEntity, HttpStatus.CREATED);
    }

    @GetMapping("/searchBook/{personId}")
    public Optional<Person> getPerson(@PathVariable @Valid int personId) {
        return personService.getPersonById(personId);
    }

    @DeleteMapping("/delete/personId")
    public List<Person> removePerson(@PathVariable @Valid int personId) {
        return personService.removePerson(personId);
    }
}
