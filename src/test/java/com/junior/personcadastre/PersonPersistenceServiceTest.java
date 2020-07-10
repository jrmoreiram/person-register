package com.junior.personcadastre;

import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.service.PersonPersistenceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonPersistenceServiceTest {

    @Mock
    private PersonPersistenceService personPersistenceService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveOrUpdatePersonSuccess() throws Exception {

        Person person = new Person();
        person.setPersonId(1);
        person.setFirstName("Júnior");
        person.setLastName("Moreira Martins");
        person.setPersonAge(32);

        when(personPersistenceService.saveOrUpdatePerson(person)).thenReturn(person);
    }
}