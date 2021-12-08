package org.stephane.output.mapper;

import org.mapstruct.Mapper;
import org.stephane.domain.entities.Personne;
import org.stephane.output.entities.PersonneEntity;

@Mapper
public abstract class PersonneEntityMapper extends ServiceMapperEntity<PersonneEntity, Personne>{
    public abstract PersonneEntity toOutput(Personne in) ;
    public abstract Personne toDomain(PersonneEntity out);
}
