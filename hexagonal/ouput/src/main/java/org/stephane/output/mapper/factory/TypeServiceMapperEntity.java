package org.stephane.output.mapper.factory;

import org.stephane.output.mapper.AdresseEntityMapper;
import org.stephane.output.mapper.PersonneEntityMapper;

public enum TypeServiceMapperEntity {
    PERSONNE(PersonneEntityMapper.class),ADRESSE(AdresseEntityMapper.class);

    private Class<? extends ServiceMapperEntity> mapperClass;
    TypeServiceMapperEntity(Class<? extends ServiceMapperEntity> mapperClass) {
        this.mapperClass = mapperClass;
    }
    public Class<? extends ServiceMapperEntity> getMapperClass(){
        return this.mapperClass;
    }

}
