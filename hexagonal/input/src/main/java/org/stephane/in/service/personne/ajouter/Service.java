package org.stephane.in.service.personne.ajouter;

import org.stephane.domain.entities.Personne;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.factory.CreateMapperDto;
import org.stephane.in.service.AjouterService;

public abstract class Service extends CreateMapperDto<PersonneDto, Personne> implements AjouterService<PersonneDto> {
}
