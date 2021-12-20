package org.stephane.output.mapper;

import org.mapstruct.Mapper;
import org.stephane.domain.entities.Personne;
import org.stephane.output.entities.PersonneEntity;
import org.stephane.output.mapper.factory.ServiceMapperEntity;

@Mapper
public abstract class PersonneEntityMapper implements ServiceMapperEntity<PersonneEntity, Personne> {
    public abstract PersonneEntity toOutput(Personne in);

    public abstract Personne toDomain(PersonneEntity out);
}
