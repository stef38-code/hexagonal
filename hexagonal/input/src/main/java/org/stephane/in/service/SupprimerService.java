package org.stephane.in.service;

public interface SupprimerService<I> {
    boolean executer(I input);

    boolean executer(String id);
}
