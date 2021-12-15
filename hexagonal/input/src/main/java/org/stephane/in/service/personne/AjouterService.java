package org.stephane.in.service.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.factory.CreateMapperDto;

public abstract class AjouterService<INPUT> {
    protected CreateMapperDto<PersonneDto, Personne> mapper;

    public abstract INPUT executer(INPUT input);
}
