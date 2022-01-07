package org.stephane.in.service.personne.supprimer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.stephane.domain.port.in.personne.SupprimerReponsePersonne;

@Component
@Slf4j
public class ReponseImpl extends SupprimerReponsePersonne {
    private boolean resultat;

    @Override
    public void donner(boolean isSupprimer) {
        resultat = isSupprimer;
    }

    @Override
    public boolean recuperer() {
        return resultat;
    }
}
