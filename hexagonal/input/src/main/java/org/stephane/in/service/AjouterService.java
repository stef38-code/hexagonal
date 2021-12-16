package org.stephane.in.service;

import org.stephane.domain.entities.Personne;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.factory.CreateMapperDto;

public abstract class AjouterService<I,D> {
    protected CreateMapperDto<I, D> mapper;
    public abstract I executer(I input);
}
