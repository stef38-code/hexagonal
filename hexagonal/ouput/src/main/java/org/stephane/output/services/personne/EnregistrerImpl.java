package org.stephane.output.services.personne;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.Enregistrer;
import org.stephane.output.entities.PersonneEntity;
import org.stephane.output.mapper.CreateMapperEntity;
import org.stephane.output.mapper.TypeServiceMapperEntity;
import org.stephane.output.repository.PersonneEntityRepository;

@RequiredArgsConstructor
@Component
public class EnregistrerImpl extends Enregistrer<Personne> {
    private final PersonneEntityRepository repository;
    private final CreateMapperEntity<PersonneEntity,Personne> mapper;
    @Override
    public Personne execute(Personne personne) {
        PersonneEntity personneEntity = mapper.getMapper(TypeServiceMapperEntity.PERSONNE).toOutput(personne);
        personneEntity = repository.save(personneEntity);
        personne = mapper.getMapper(TypeServiceMapperEntity.PERSONNE).toDomain(personneEntity);
        return personne;
    }
}
