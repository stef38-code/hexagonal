package org.stephane.output.services.personne;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.personne.SelectionnerPersonneOut;
import org.stephane.output.entities.PersonneEntity;
import org.stephane.output.mapper.factory.CreateMapperEntity;
import org.stephane.output.mapper.factory.TypeServiceMapperEntity;
import org.stephane.output.repository.PersonneEntityRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SelectiionnerPersonneOutImpl extends CreateMapperEntity<PersonneEntity, Personne> implements SelectionnerPersonneOut {
    private final PersonneEntityRepository repository;

    @Override
    public Personne executer(String id) {
        Optional<PersonneEntity> byId = repository.findById(id);
        Personne personne = getMapper(TypeServiceMapperEntity.PERSONNE).toDomain(byId.orElseGet(null));
        return personne;
    }

    @Override
    public List<Personne> executer() {
        List<PersonneEntity> all = repository.findAll();
        return getMapper(TypeServiceMapperEntity.PERSONNE).toDomain(all);
    }
}
