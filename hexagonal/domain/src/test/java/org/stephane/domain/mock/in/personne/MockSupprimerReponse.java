package org.stephane.domain.mock.in.personne;

import org.stephane.domain.port.in.personne.SupprimerReponse;

public class MockSupprimerReponse implements SupprimerReponse {
    private String idPersonne;


    @Override
    public void donner(String idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public String recuperer() {
        return idPersonne;
    }


}
