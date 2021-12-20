package org.stephane.in.service;

import java.util.List;

public interface SelectionnerService<I> {
    List<I> executer();
    I executer(String id);
}
