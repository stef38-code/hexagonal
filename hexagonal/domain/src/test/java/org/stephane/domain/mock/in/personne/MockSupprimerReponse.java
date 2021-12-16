package org.stephane.domain.mock.in.personne;

import org.stephane.domain.port.in.SupprimerReponse;

public class MockSupprimerReponse extends SupprimerReponse {

    @Override
    public void donner(boolean isSupprimer) {
        this.isSupprimer = isSupprimer;
    }

    @Override
    public boolean recuperer() {
        return isSupprimer;
    }
}
