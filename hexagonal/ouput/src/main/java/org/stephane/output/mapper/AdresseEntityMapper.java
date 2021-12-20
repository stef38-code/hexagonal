package org.stephane.output.mapper;

import org.mapstruct.Mapper;
import org.stephane.domain.entities.Adresse;
import org.stephane.output.entities.AdresseEntity;
import org.stephane.output.mapper.factory.ServiceMapperEntity;

@Mapper
public abstract class AdresseEntityMapper implements ServiceMapperEntity<AdresseEntity, Adresse> {
    public abstract AdresseEntity toOutput(Adresse in);

    public abstract Adresse toDomain(AdresseEntity out);
}
