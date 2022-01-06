package org.stephane.in.service.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.factory.CreateMapperDto;
import org.stephane.in.service.AjouterService;
import org.stephane.in.service.SupprimerService;

public abstract class SupprimerServicePersonne extends CreateMapperDto<PersonneDto, Personne> implements SupprimerService<PersonneDto> {
}
