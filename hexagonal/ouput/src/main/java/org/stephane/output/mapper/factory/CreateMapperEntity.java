package org.stephane.output.mapper.factory;

public class CreateMapperEntity<O, D> {
    public ServiceMapperEntity<O, D> getMapper(TypeServiceMapperEntity mapperType) {
        return getServicePfsFactory().create(mapperType);
    }

    protected ServiceMapperFactoryEntity<O, D> getServicePfsFactory() {
        return new ServiceMapperFactoryEntityImpl();
    }
}
