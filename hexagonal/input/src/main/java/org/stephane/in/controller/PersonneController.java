package org.stephane.in.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.service.AjouterUnePersonneService;

import javax.validation.Valid;

@RestController
@RequestMapping(
        value = "personnes",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class PersonneController {
    private final AjouterUnePersonneService ajouterUnePersonneService;

    @PostMapping
    public ResponseEntity<PersonneDto> enregistrer(@Valid @RequestBody PersonneDto personneDto) {
        personneDto = ajouterUnePersonneService.ajouter(personneDto);
        return new ResponseEntity<>(personneDto, HttpStatus.OK);
    }

    /*@GetMapping
    public ResponseEntity<Collection<PersonneDto>> lister() {
        //return new ResponseEntity<>(categoriePortIn.lister(), HttpStatus.OK);
    }*/

   /* @GetMapping("/{id}")
    public ResponseEntity<CategorieDto> editer(@PathVariable final String id) {
        CategorieDto categorieDto = categoriePortIn.editer(id);
        CategorieResource.addLinkByRef(categorieDto);
        return ResponseEntity.ok(categorieDto);
    }

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
