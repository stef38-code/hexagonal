package org.stephane.in.mapper.factory;

public class CreateMapperDto<I, D> {
    public ServiceMapperDto<I, D> getMapper(TypeServiceMapperDto mapperType) {
        return getServicePfsFactory().create(mapperType);
    }

    protected ServiceMapperFactoryDto<I, D> getServicePfsFactory() {
        return new ServiceMapperFactoryDtoImpl<>();
    }
}
