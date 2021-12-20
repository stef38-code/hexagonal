package org.stephane.output.services.personne;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.personne.AjouterPersonneOut;
import org.stephane.output.entities.PersonneEntity;
import org.stephane.output.mapper.factory.CreateMapperEntity;
import org.stephane.output.mapper.factory.TypeServiceMapperEntity;
import org.stephane.output.repository.PersonneEntityRepository;

@RequiredArgsConstructor
@Component
@Slf4j
public class AjouterPersonneOutImpl extends CreateMapperEntity<PersonneEntity, Personne> implements AjouterPersonneOut {
    private final PersonneEntityRepository repository;

    @Override
    public Personne execute(Personne personne) {
        log.info("ouput:AjouterPersonneOut:DEBUT---------------------------------------------");
        PersonneEntity personneEntity = getMapper(TypeServiceMapperEntity.PERSONNE).toOutput(personne);
        personneEntity = repository.save(personneEntity);
        personne = getMapper(TypeServiceMapperEntity.PERSONNE).toDomain(personneEntity);
        log.info("ouput:AjouterPersonneOut:FIN---------------------------------------------");
        return personne;
    }
}
