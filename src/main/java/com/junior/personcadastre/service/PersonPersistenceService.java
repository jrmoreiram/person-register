package com.junior.personcadastre.service;

import com.junior.personcadastre.api.mapper.PersonMapper;
import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.exception.BadRequestException;
import com.junior.personcadastre.exception.NotFoundException;
import com.junior.personcadastre.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonPersistenceService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonPersistenceService.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonSearchService personSearchService;

    @Transactional(propagation = Propagation.REQUIRED)
    public Person saveOrUpdatePerson(Person personSave) {
        return personRepository.save(personSave);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String removePerson(int personId) throws Exception {

        Optional<Person> personList = personRepository.findById(personId);

        if (!personList.isPresent()) {
            throw new BadRequestException("Error deleting person ID: " + personId);
        } else {
            personRepository.deleteById(personId);

            String message = "Person ID: " + personId + " removed with success!.";
            return message;
        }
    }
}