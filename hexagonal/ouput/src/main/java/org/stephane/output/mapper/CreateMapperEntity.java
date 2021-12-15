package org.stephane.output.mapper;

public class CreateMapperEntity<OUT, DOM> {
    public ServiceMapperEntity<OUT, DOM> getMapper(TypeServiceMapperEntity mapperType) {
        return getServicePfsFactory().create(mapperType);
    }

    protected ServiceMapperFactoryEntity<OUT, DOM> getServicePfsFactory() {
        return new ServiceMapperFactoryEntityImpl<>();
    }
}
