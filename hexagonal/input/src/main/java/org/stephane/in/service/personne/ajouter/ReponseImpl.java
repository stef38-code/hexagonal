package org.stephane.in.service.personne.ajouter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponsePersonne;

@Component
@Slf4j
public class ReponseImpl extends AjouterReponsePersonne {
    private Personne resultat;

    @Override
    public void donner(Personne resultat) {
        log.info("input:Reponse:donner---------------------------------------------");
        this.resultat = resultat;
    }

    @Override
    public Personne recuperer() {
        log.info("input:Reponse:recuperer---------------------------------------------");
        return resultat;
    }
}
