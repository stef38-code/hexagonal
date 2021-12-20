package org.stephane.in.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.service.personne.AjouterServicePersonne;
import org.stephane.in.service.personne.SelectionnerServicePersonne;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(
        value = "personnes",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
@Slf4j
public class PersonneController {
    private final AjouterServicePersonne ajouterService;
    private final SelectionnerServicePersonne selectionnerService;

    @PostMapping
    public ResponseEntity<PersonneDto> enregistrer(@Valid @RequestBody PersonneDto personneDto) {
        log.info("input:controler:DEBUT---------------------------------------------");
        personneDto = ajouterService.executer(personneDto);
        log.info("input:controler:FIN---------------------------------------------");
        return new ResponseEntity<>(personneDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<PersonneDto>> lister() {
        List<PersonneDto> liste = selectionnerService.executer();
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonneDto> editer(@PathVariable final String id) {
        PersonneDto personneDto = selectionnerService.executer(id);
        return new ResponseEntity<>(personneDto, HttpStatus.OK);
    }
/*
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
//  @CacheEvict(value = "categories", allEntries = true)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> supprimer(@PathVariable final String id) {
        categoriePortIn.supprimer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
//  @CacheEvict(value = "categories", allEntries = true)
    public ResponseEntity<Void> modifier(@RequestBody CategorieEntityController entityController) {
        categoriePortIn.modifier(
                entityController.getAncienneCategorie(), entityController.getNouvelleCategorie());
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
