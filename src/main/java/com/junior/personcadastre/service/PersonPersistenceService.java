package com.junior.personcadastre.service;

import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.exception.BadRequestException;
import com.junior.personcadastre.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonPersistenceService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonPersistenceService.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonSearchService personSearchService;

    @Transactional(propagation = Propagation.REQUIRED)
    public Person saveOrUpdatePerson(Person personSave) throws Exception {
        Person person;
        try {
            person = personRepository.save(personSave);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new BadRequestException("Ocorreu um erro ao salvar a pessoa ID: " + personSave.getPersonId());
        }

        return person;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void removePerson(int personId) throws Exception {
        try {
            personRepository.deleteById(personId);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new BadRequestException("Ocorreu um erro ao excluir a pessoa ID: " + personId);
        }
    }
}
