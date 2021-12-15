package org.stephane.domain.port.in;

public abstract class SupprimerReponse<DOM> {
    private boolean isSupprime;
    public void donner(boolean isSupprimer){
        this.isSupprime = isSupprimer;
    }
    public boolean recuperer() {
        return isSupprime;
    }
}
