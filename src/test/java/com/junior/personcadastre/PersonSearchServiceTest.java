package com.junior.personcadastre;

import com.junior.personcadastre.api.mapper.PageableMapper;
import com.junior.personcadastre.api.param.PaginationParam;
import com.junior.personcadastre.api.param.SortParam;
import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.exception.NotFoundException;
import com.junior.personcadastre.repository.PersonRepository;
import com.junior.personcadastre.service.PersonSearchService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonSearchServiceTest {

    @InjectMocks
    private PersonSearchService personSearchService;

    @Mock
    private PersonRepository personRepository;

    @Test
    public void testFindByIdSuccess() {

        Person person = new Person(1, "Junior", "Martins", 33);

        when(personRepository.findById(1)).thenReturn(Optional.of(person));
        Person result = personSearchService.findById(1);

        assertThat(result.getPersonId()).isEqualTo(Integer.valueOf(1));
        assertThat(result.getFirstName()).isEqualTo("Junior");
        assertThat(result.getLastName()).isEqualTo("Martins");
        assertThat(result.getPersonAge()).isEqualTo(33);
    }

    @Test
    public void testFindByIdException() {

        Person person = new Person(1, "Junior", "Martins", 33);

        when(personRepository.findById(1)).thenReturn(Optional.of(person));

        Throwable result = catchThrowable(() -> personSearchService.findById(2));
        assertThat(result).hasNoCause()
                .isExactlyInstanceOf(NotFoundException.class)
                .hasMessage("Person not found.");
    }

    @Test
    public void testFindAll() {

        PaginationParam pagination = new PaginationParam();
        SortParam sort = new SortParam();

        Pageable pageable = PageableMapper.paramsToPageable(pagination, sort);

        Person person = new Person(1, "Junior", "Martins", 33);
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        Page<Person> page = new PageImpl(personList, pageable, 1000);

        when(personRepository.findAll(pageable)).thenReturn(page);
        Page<Person> result = personSearchService.findAll(pageable);

        assertThat(result.getContent()).isEqualTo(page.getContent());
    }
}