package org.stephane.domain.entities.builder;

public interface BuilderValidation<T> {
    T build();

    void validate();
}
