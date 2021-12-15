package org.stephane.in.mapper;

import javax.annotation.processing.Generated;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.entities.Personne.Builder;
import org.stephane.in.dto.PersonneDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-15T15:04:28+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.8 (Azul Systems, Inc.)"
)
public class PersonneDtoMapperImpl extends PersonneDtoMapper {

    @Override
    public PersonneDto toInput(Personne personne) {
        if ( personne == null ) {
            return null;
        }

        PersonneDto personneDto = new PersonneDto();

        personneDto.setId( personne.getId() );
        personneDto.setNom( personne.getNom() );
        personneDto.setPrenom( personne.getPrenom() );
        personneDto.setDateNaissance( personne.getDateNaissance() );

        return personneDto;
    }

    @Override
    public Personne toDomain(PersonneDto personneDto) {
        if ( personneDto == null ) {
            return null;
        }

        Builder builder = null;

        Personne personne = new Personne( builder );

        personne.setId( personneDto.getId() );
        personne.setNom( personneDto.getNom() );
        personne.setPrenom( personneDto.getPrenom() );
        personne.setDateNaissance( personneDto.getDateNaissance() );

        return personne;
    }
}