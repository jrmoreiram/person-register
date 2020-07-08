package com.junior.personcadastre.service;

import com.junior.personcadastre.api.PersonDTO;
import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void getAllPerson(){
        personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> getPersonById(int personId) {
        return personRepository.findById(personId);
    }

    public List<Person> removePerson(int personId){
        personRepository.deleteById(personId);
        return personRepository.findAll();
    }
}
