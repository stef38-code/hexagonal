package org.stephane.in.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.stephane.domain.entities.Personne;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.factory.ServiceMapperDto;

@Mapper
public abstract class PersonneDtoMapper extends ServiceMapperDto<PersonneDto, Personne> {

    public abstract PersonneDto toInput(Personne personne);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nom", source = "nom")
    public abstract Personne toDomain(PersonneDto personneDto);
}
