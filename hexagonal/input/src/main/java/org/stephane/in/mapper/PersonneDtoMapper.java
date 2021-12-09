package org.stephane.in.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.stephane.domain.entities.Personne;
import org.stephane.in.dto.PersonneDto;

@Mapper
public interface PersonneDtoMapper {
    PersonneDtoMapper INSTANCE = Mappers.getMapper( PersonneDtoMapper.class );
    PersonneDto to(Personne personne);
    Personne to(PersonneDto personneDto);
}
