package com.junior.personcadastre.api.controller;

import com.junior.personcadastre.api.dto.PersonCreateDTO;
import com.junior.personcadastre.api.dto.PersonDTO;
import com.junior.personcadastre.api.dto.PersonListDTO;
import com.junior.personcadastre.api.dto.PersonUpdateDTO;
import com.junior.personcadastre.api.mapper.PageableMapper;
import com.junior.personcadastre.api.mapper.PersonMapper;
import com.junior.personcadastre.api.param.PaginationParam;
import com.junior.personcadastre.api.param.SortParam;
import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.service.PersonPersistenceService;
import com.junior.personcadastre.service.PersonSearchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonPersistenceService personPersistenceService;

    @Autowired
    private PersonSearchService personSearchService;

    @GetMapping
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonListDTO.class),
            @ApiResponse(code = 400, message = "Error find all person"),
            @ApiResponse(code = 404, message = "Person not found"),
            @ApiResponse(code = 500, message = "Internal server error has occurred")
    })
    @ApiOperation("Find all person")
    public ResponseEntity<PersonListDTO> find(PaginationParam pagination, SortParam sort) {
        Pageable pageable = PageableMapper.paramsToPageable(pagination, sort);
        return ResponseEntity.ok(PersonMapper.fromEntities(personSearchService.findAll(pageable)));
    }

    @PostMapping("/save")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Error saving person"),
            @ApiResponse(code = 500, message = "Internal server error has occurred")
    })
    @ApiOperation("Insert person")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody @Valid PersonCreateDTO person) throws Exception {
        Person personCreate = personPersistenceService.saveOrUpdatePerson(PersonMapper.fromCreateDTO(person));
        return ResponseEntity.ok(PersonMapper.fromEntity(personPersistenceService.saveOrUpdatePerson(personCreate)));

    }

    @PutMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Error editing person"),
            @ApiResponse(code = 500, message = "Internal server error has occurred")
    })
    @ApiOperation("Edit person by ID")
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody @Valid PersonUpdateDTO person, @PathVariable @Valid int id) throws Exception {
        Person personUpdate = PersonMapper.fromUpdateDTO(id, person);
        return ResponseEntity.ok(PersonMapper.fromEntity(personPersistenceService.saveOrUpdatePerson(personUpdate)));
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Error find person by ID"),
            @ApiResponse(code = 404, message = "Person not found"),
            @ApiResponse(code = 500, message = "Internal server error has occurred")
    })
        @ApiOperation("Find person by ID")
    public ResponseEntity<PersonDTO> findById(@PathVariable @Valid int id) throws Exception {
        return ResponseEntity.ok(PersonMapper.fromEntity(personSearchService.findById(id)));
    }

    @DeleteMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Error deleting person"),
            @ApiResponse(code = 500, message = "Internal server error has occurred")
    })
    @ApiOperation("Remove person")
    public String removePerson(@PathVariable @Valid int id) throws Exception {
        return personPersistenceService.removePerson(id);
    }
}