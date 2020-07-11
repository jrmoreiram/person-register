package com.junior.personcadastre;

import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.exception.BadRequestException;
import com.junior.personcadastre.repository.PersonRepository;
import com.junior.personcadastre.service.PersonPersistenceService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonPersistenceServiceTest {

    @InjectMocks
    private PersonPersistenceService personPersistenceService;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveOrUpdatePersonSuccess() throws Exception {

        Person personSave = Person.PersonBuilder.of()
                .personId(1)
                .firstName("Junior")
                .lastName("Martins")
                .personAge(32)
                .build();

        when(personPersistenceService.saveOrUpdatePerson(personSave)).thenReturn(personSave);

        assertThat(personSave.getPersonId()).isEqualTo(Integer.valueOf(1));
        assertThat(personSave.getFirstName()).isEqualTo("Junior");
        assertThat(personSave.getLastName()).isEqualTo("Martins");
        assertThat(personSave.getPersonAge()).isEqualTo(32);

    }

    @Test
    public void testRemovePersonSuccess() throws Exception {
        Person personRemove = Person.PersonBuilder.of()
                .personId(1)
                .firstName("Junior")
                .lastName("Moreira")
                .personAge(32)
                .build();

        when(personRepository.findById(1)).thenReturn(Optional.of(personRemove));

        String messageExpected = "Person ID: 1 removed with success!.";
        String messageResponse = personPersistenceService.removePerson(personRemove.getPersonId());

        assertThat(messageExpected).isEqualTo(messageResponse);

    }

    @Test
    public void testRemovePersonException() throws Exception {

        Throwable result = catchThrowable(() -> personPersistenceService.removePerson(1));

        assertThat(result).hasNoCause()
                .isExactlyInstanceOf(BadRequestException.class)
                .hasMessage("Error deleting person ID: 1");
    }
}