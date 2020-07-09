package com.junior.personcadastre.api;

import com.junior.personcadastre.domain.Person;
import com.junior.personcadastre.mapper.PageableMapper;
import com.junior.personcadastre.mapper.PersonMapper;
import com.junior.personcadastre.param.PaginationParam;
import com.junior.personcadastre.param.SortParam;
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
            @ApiResponse(code = 400, message = "Erro na consulta de Pessoa"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Consulta todas as pessoas")
    public ResponseEntity<PersonListDTO> find(PaginationParam pagination, SortParam sort) {
        Pageable pageable = PageableMapper.paramsToPageable(pagination, sort);
        return ResponseEntity.ok(PersonMapper.fromEntities(personSearchService.findAll(pageable)));
    }

    @PostMapping("/save")
    @ApiResponses({
            @ApiResponse(code = 201, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Erro ao salvar uma pessoa"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Criação da pessoa")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody @Valid PersonCreateDTO person) throws Exception {
        Person personCreate = personPersistenceService.saveOrUpdatePerson(PersonMapper.fromCreateDTO(person));
        return ResponseEntity.ok(PersonMapper.fromEntity(personPersistenceService.saveOrUpdatePerson(personCreate)));

    }

    @PutMapping("/save/{personId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Erro na alteração da Pessoa"),
            @ApiResponse(code = 404, message = "Pessoa não encontrado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Alteração da pessoa pelo id")
    public ResponseEntity<PersonDTO> update(@RequestBody @Valid PersonUpdateDTO person, @PathVariable @Valid int personId) throws Exception {
        Person personUpdate = PersonMapper.fromUpdateDTO(personId, person);
        return ResponseEntity.ok(PersonMapper.fromEntity(personPersistenceService.saveOrUpdatePerson(personUpdate)));
    }

    @GetMapping("search/{personId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Erro na consulta da Pessoa"),
            @ApiResponse(code = 404, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Consulta de pessoa pelo id")
    public ResponseEntity<PersonDTO> findByPersonId(@PathVariable @Valid int personId) throws Exception {
        return ResponseEntity.ok(PersonMapper.fromEntity(personSearchService.findById(personId)));
    }

    @DeleteMapping("/delete/{personId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Erro ao deletar uma pessoa"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno no servidor")
    })
    @ApiOperation("Remove pessoa")
    public void removePerson(@PathVariable @Valid int personId) throws Exception {
        personPersistenceService.removePerson(personId);
    }
}
