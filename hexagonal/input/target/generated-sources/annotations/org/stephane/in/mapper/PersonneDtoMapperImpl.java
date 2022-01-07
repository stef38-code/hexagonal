package org.stephane.in.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.stephane.domain.entities.Adresse;
import org.stephane.domain.entities.Personne;
import org.stephane.in.dto.AdresseDto;
import org.stephane.in.dto.PersonneDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-06T16:02:00+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Azul Systems, Inc.)"
)
public class PersonneDtoMapperImpl extends PersonneDtoMapper {

    @Override
    public List<PersonneDto> toInput(List<Personne> in) {
        if ( in == null ) {
            return null;
        }

        List<PersonneDto> list = new ArrayList<PersonneDto>( in.size() );
        for ( Personne personne : in ) {
            list.add( toInput( personne ) );
        }

        return list;
    }

    @Override
    public List<Personne> toDomain(List<PersonneDto> out) {
        if ( out == null ) {
            return null;
        }

        List<Personne> list = new ArrayList<Personne>( out.size() );
        for ( PersonneDto personneDto : out ) {
            list.add( toDomain( personneDto ) );
        }

        return list;
    }

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
        personneDto.setAdresses( adresseSetToAdresseDtoSet( personne.getAdresses() ) );

        return personneDto;
    }

    @Override
    public Personne toDomain(PersonneDto personneDto) {
        if ( personneDto == null ) {
            return null;
        }

        Personne personne = new Personne();

        personne.setId( personneDto.getId() );
        personne.setNom( personneDto.getNom() );
        personne.setPrenom( personneDto.getPrenom() );
        personne.setDateNaissance( personneDto.getDateNaissance() );
        personne.setAdresses( adresseDtoSetToAdresseSet( personneDto.getAdresses() ) );

        return personne;
    }

    protected Set<PersonneDto> personneSetToPersonneDtoSet(Set<Personne> set) {
        if ( set == null ) {
            return null;
        }

        Set<PersonneDto> set1 = new HashSet<PersonneDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Personne personne : set ) {
            set1.add( toInput( personne ) );
        }

        return set1;
    }

    protected AdresseDto adresseToAdresseDto(Adresse adresse) {
        if ( adresse == null ) {
            return null;
        }

        AdresseDto adresseDto = new AdresseDto();

        adresseDto.setId( adresse.getId() );
        adresseDto.setAppartementEscalierEtage( adresse.getAppartementEscalierEtage() );
        adresseDto.setBatimentResidence( adresse.getBatimentResidence() );
        adresseDto.setNumeroNomVoie( adresse.getNumeroNomVoie() );
        adresseDto.setComplementAdresse( adresse.getComplementAdresse() );
        adresseDto.setCodePostal( adresse.getCodePostal() );
        adresseDto.setVille( adresse.getVille() );
        adresseDto.setPays( adresse.getPays() );
        adresseDto.setPersonnes( personneSetToPersonneDtoSet( adresse.getPersonnes() ) );

        return adresseDto;
    }

    protected Set<AdresseDto> adresseSetToAdresseDtoSet(Set<Adresse> set) {
        if ( set == null ) {
            return null;
        }

        Set<AdresseDto> set1 = new HashSet<AdresseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Adresse adresse : set ) {
            set1.add( adresseToAdresseDto( adresse ) );
        }

        return set1;
    }

    protected Set<Personne> personneDtoSetToPersonneSet(Set<PersonneDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Personne> set1 = new HashSet<Personne>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PersonneDto personneDto : set ) {
            set1.add( toDomain( personneDto ) );
        }

        return set1;
    }

    protected Adresse adresseDtoToAdresse(AdresseDto adresseDto) {
        if ( adresseDto == null ) {
            return null;
        }

        Adresse adresse = new Adresse();

        adresse.setId( adresseDto.getId() );
        adresse.setAppartementEscalierEtage( adresseDto.getAppartementEscalierEtage() );
        adresse.setBatimentResidence( adresseDto.getBatimentResidence() );
        adresse.setNumeroNomVoie( adresseDto.getNumeroNomVoie() );
        adresse.setComplementAdresse( adresseDto.getComplementAdresse() );
        adresse.setCodePostal( adresseDto.getCodePostal() );
        adresse.setVille( adresseDto.getVille() );
        adresse.setPays( adresseDto.getPays() );
        adresse.setPersonnes( personneDtoSetToPersonneSet( adresseDto.getPersonnes() ) );

        return adresse;
    }

    protected Set<Adresse> adresseDtoSetToAdresseSet(Set<AdresseDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Adresse> set1 = new HashSet<Adresse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AdresseDto adresseDto : set ) {
            set1.add( adresseDtoToAdresse( adresseDto ) );
        }

        return set1;
    }
}
