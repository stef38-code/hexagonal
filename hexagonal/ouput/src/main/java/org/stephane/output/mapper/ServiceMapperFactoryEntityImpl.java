package org.stephane.output.mapper;

import org.mapstruct.factory.Mappers;

public class ServiceMapperFactoryEntityImpl<OUT, DOM> extends ServiceMapperFactoryEntity<OUT, DOM> {
    @Override
    public ServiceMapperEntity<OUT, DOM> create(TypeServiceMapperEntity type) {
        switch (type){
            case PERSONNE:
                ServiceMapperEntity mapper = Mappers.getMapper( PersonneEntityMapper.class );
                return mapper;
            default:
                throw new IllegalArgumentException("Ce mapper n'est pas definit");
        }
    }
}
