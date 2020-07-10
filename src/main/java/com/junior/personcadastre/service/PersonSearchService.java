package com.junior.personcadastre.service;

import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.exception.BaseException;
import com.junior.personcadastre.exception.NotFoundException;
import com.junior.personcadastre.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonSearchService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Person findById(int personId) throws BaseException {
        return personRepository.findById(personId).orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<Person> findAll(Pageable pagination) {
        return personRepository.findAll(pagination);
    }
}