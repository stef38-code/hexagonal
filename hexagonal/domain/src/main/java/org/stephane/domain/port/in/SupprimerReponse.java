package org.stephane.domain.port.in;

public abstract class SupprimerReponse {
    protected boolean isSupprimer;
    public abstract void donner(boolean isSupprimer);
    public abstract boolean recuperer() ;
}
