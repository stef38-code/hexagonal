package org.stephane.in.mapper;

import org.mapstruct.Mapper;
import org.stephane.domain.entities.Adresse;
import org.stephane.in.dto.AdresseDto;
import org.stephane.in.mapper.factory.ServiceMapperDto;

@Mapper
public abstract class AdresseDtoMapper extends ServiceMapperDto<AdresseDto, Adresse> {
    public abstract  AdresseDto toInput(Adresse in) ;
    public abstract Adresse toDomain(AdresseDto out) ;
}
