package org.stephane.output.services.personne;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.personne.SupprimerPersonneOut;
import org.stephane.output.entities.PersonneEntity;
import org.stephane.output.mapper.factory.CreateMapperEntity;
import org.stephane.output.mapper.factory.TypeServiceMapperEntity;
import org.stephane.output.repository.PersonneEntityRepository;

@RequiredArgsConstructor
@Component
public class SupprimerPersonneOutImpl extends CreateMapperEntity<PersonneEntity, Personne> implements SupprimerPersonneOut {
    private final PersonneEntityRepository repository;

    @Override
    public boolean execute(Personne personne) {
        PersonneEntity personneEntity = getMapper(TypeServiceMapperEntity.PERSONNE).toOutput(personne);
        repository.delete(personneEntity);
        return true;
    }

    @Override
    public boolean execute(String id) {
        repository.deleteById(id);
        return true;
    }
}
