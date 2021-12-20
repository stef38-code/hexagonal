package org.stephane.output.mapper.factory;

import java.util.List;

/**
 *
 * @param <O>
 * @param <D>
 */
public interface ServiceMapperEntity<O, D> {
    public abstract O toOutput(D in);

    public abstract List<O> toOutput(List<D> in);

    public abstract D toDomain(O out);

    public abstract List<D> toDomain(List<O> out);
}
