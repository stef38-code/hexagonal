package org.stephane.output.mapper.factory;

import java.util.List;

/**
 * O obj ouput
 * D obj domain
 */
public interface ServiceMapperEntity<O, D> {
    O toOutput(D in);

    List<O> toOutput(List<D> in);

    D toDomain(O out);

    List<D> toDomain(List<O> out);
}
