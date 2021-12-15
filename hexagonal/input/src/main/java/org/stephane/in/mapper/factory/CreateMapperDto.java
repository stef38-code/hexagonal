package org.stephane.in.mapper.factory;

public class CreateMapperDto<IN, DOM> {
    public ServiceMapperDto<IN, DOM> getMapper(TypeServiceMapperDto mapperType) {
        return getServicePfsFactory().create(mapperType);
    }

    protected ServiceMapperFactoryDto<IN, DOM> getServicePfsFactory() {
        return new ServiceMapperFactoryDtoImpl<>();
    }
}
