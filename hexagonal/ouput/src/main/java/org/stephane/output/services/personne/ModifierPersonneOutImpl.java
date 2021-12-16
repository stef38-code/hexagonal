package org.stephane.output.services.personne;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.personne.AjouterPersonneOut;
import org.stephane.domain.port.out.personne.ModifierPersonneOut;
import org.stephane.output.entities.PersonneEntity;
import org.stephane.output.mapper.TypeServiceMapperEntity;
import org.stephane.output.mapper.factory.CreateMapperEntity;
import org.stephane.output.repository.PersonneEntityRepository;

@RequiredArgsConstructor
@Component
public class ModifierPersonneOutImpl extends CreateMapperEntity<PersonneEntity, Personne> implements ModifierPersonneOut {
    private final PersonneEntityRepository repository;

    @Override
    public Personne execute(Personne personne) {
        PersonneEntity personneEntity = getMapper(TypeServiceMapperEntity.PERSONNE).toOutput(personne);
        personneEntity = repository.save(personneEntity);
        personne = getMapper(TypeServiceMapperEntity.PERSONNE).toDomain(personneEntity);
        return personne;
    }
}
