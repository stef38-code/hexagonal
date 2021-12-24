package org.stephane.tools;

import java.util.List;

public interface GenererDonnees<T> {
    List<T> genererListe(int nombre);

    T generer();
}
