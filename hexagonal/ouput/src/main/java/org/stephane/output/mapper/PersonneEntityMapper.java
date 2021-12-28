package org.stephane.output.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.stephane.domain.entities.Adresse;
import org.stephane.domain.entities.Personne;
import org.stephane.output.entities.AdresseEntity;
import org.stephane.output.entities.PersonneEntity;
import org.stephane.output.mapper.factory.ServiceMapperEntity;

import java.util.Set;

@Mapper
public abstract class PersonneEntityMapper implements ServiceMapperEntity<PersonneEntity, Personne> {

    public abstract PersonneEntity toOutput(Personne in);

    @Mapping(source = "adresses", target = "adresses", qualifiedByName = "Adresses")
    public abstract Personne toDomain(PersonneEntity out);

    @Named("Adresses")
    @IterableMapping(qualifiedByName="Adresse")//pour ne pas avoir un effet circulaire
    public abstract Set<Adresse> toAdresses(Set<AdresseEntity> adresseEntities);

    @Named("Adresse")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "appartementEscalierEtage", source = "appartementEscalierEtage")
    @Mapping(target = "batimentResidence", source = "batimentResidence")
    @Mapping(target = "numeroNomVoie", source = "numeroNomVoie")
    @Mapping(target = "complementAdresse", source = "complementAdresse")
    @Mapping(target = "codePostal", source = "codePostal")
    @Mapping(target = "ville", source = "ville")
    @Mapping(target = "pays", source = "pays")
    @Mapping(target = "personnes", ignore = true)
    public abstract Adresse adresseEntityToAdresse(AdresseEntity adresseEntities);

    @Named("AdressesEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "appartementEscalierEtage", source = "appartementEscalierEtage")
    @Mapping(target = "batimentResidence", source = "batimentResidence")
    @Mapping(target = "numeroNomVoie", source = "numeroNomVoie")
    @Mapping(target = "complementAdresse", source = "complementAdresse")
    @Mapping(target = "codePostal", source = "codePostal")
    @Mapping(target = "ville", source = "ville")
    @Mapping(target = "pays", source = "pays")
    @Mapping(target = "personnes", ignore = true)
    public abstract AdresseEntity toAdresseEntity(Adresse adresseEntitie);
}
