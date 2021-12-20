package org.stephane.in.service.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.factory.CreateMapperDto;
import org.stephane.in.service.SelectionnerService;

public abstract class SelectionnerServicePersonne extends CreateMapperDto<PersonneDto, Personne> implements SelectionnerService<PersonneDto> {
}
