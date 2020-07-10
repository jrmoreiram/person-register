package com.junior.personcadastre.api.controller;

import com.junior.personcadastre.api.dto.PersonCreateDTO;
import com.junior.personcadastre.api.dto.PersonDTO;
import com.junior.personcadastre.api.dto.PersonListDTO;
import com.junior.personcadastre.api.dto.PersonUpdateDTO;
import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.api.mapper.PageableMapper;
import com.junior.personcadastre.api.mapper.PersonMapper;
import com.junior.personcadastre.api.param.PaginationParam;
import com.junior.personcadastre.api.param.SortParam;
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
            @ApiResponse(code = 400, message = "Erro ao consultar pessoas"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Consulta pessoas")
    public ResponseEntity<PersonListDTO> find(PaginationParam pagination, SortParam sort) {
        Pageable pageable = PageableMapper.paramsToPageable(pagination, sort);
        return ResponseEntity.ok(PersonMapper.fromEntities(personSearchService.findAll(pageable)));
    }

    @PostMapping("/save")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Erro ao salvar pessoa"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Insere pessoa")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody @Valid PersonCreateDTO person) throws Exception {
        Person personCreate = personPersistenceService.saveOrUpdatePerson(PersonMapper.fromCreateDTO(person));
        return ResponseEntity.ok(PersonMapper.fromEntity(personPersistenceService.saveOrUpdatePerson(personCreate)));

    }

    @PutMapping("/save/{personId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Erro ao editar pessoa"),
            @ApiResponse(code = 404, message = "Pessoa não encontrado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Edita pessoa pelo ID")
    public ResponseEntity<PersonDTO> update(@RequestBody @Valid PersonUpdateDTO person, @PathVariable @Valid int personId) throws Exception {
        Person personUpdate = PersonMapper.fromUpdateDTO(personId, person);
        return ResponseEntity.ok(PersonMapper.fromEntity(personPersistenceService.saveOrUpdatePerson(personUpdate)));
    }

    @GetMapping("search/{personId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Erro ao consultar pessoa"),
            @ApiResponse(code = 404, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Consulta pessoa pelo ID")
    public ResponseEntity<PersonDTO> findByPersonId(@PathVariable @Valid int personId) throws Exception {
        return ResponseEntity.ok(PersonMapper.fromEntity(personSearchService.findById(personId)));
    }

    @DeleteMapping("/delete/{personId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Erro ao deletar pessoa"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Remove pessoa")
    public void removePerson(@PathVariable @Valid int personId) throws Exception {
        personPersistenceService.removePerson(personId);
    }
}
