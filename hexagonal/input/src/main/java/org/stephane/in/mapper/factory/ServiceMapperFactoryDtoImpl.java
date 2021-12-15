package org.stephane.in.mapper.factory;

import org.mapstruct.factory.Mappers;
import org.stephane.in.mapper.PersonneDtoMapper;

public class ServiceMapperFactoryDtoImpl<IN, DOM> extends ServiceMapperFactoryDto<IN, DOM> {
    @Override
    public ServiceMapperDto<IN, DOM> create(TypeServiceMapperDto type) {
        switch (type){
            case PERSONNE:
                ServiceMapperDto mapper = Mappers.getMapper( PersonneDtoMapper.class );
                return mapper;
            default:
                throw new IllegalArgumentException("Ce mapper n'est pas definit");
        }
    }
}
