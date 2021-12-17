package org.stephane.in.mapper.factory;

import org.stephane.in.mapper.AdresseDtoMapper;
import org.stephane.in.mapper.PersonneDtoMapper;

public enum TypeServiceMapperDto {
    PERSONNE(PersonneDtoMapper.class),ADRESSE(AdresseDtoMapper.class);

    private Class<? extends ServiceMapperDto> mapperClass;

    TypeServiceMapperDto(Class<? extends ServiceMapperDto> mapperClass) {
        this.mapperClass = mapperClass;
    }
    public Class<? extends ServiceMapperDto> getMapperClass(){
        return this.mapperClass;
    }
}
