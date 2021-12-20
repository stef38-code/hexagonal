package org.stephane.in.service.personne;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.SelectionnerReponsePersonne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class SelectionnerReponsePersonneImpl extends SelectionnerReponsePersonne {
    private List<Personne> personnes;
    @Override
    public void donnee(Personne resultat) {
        log.info("input:Reponse:donner---------------------------------------------");
        if(Objects.isNull(personnes)){
            this.personnes = new ArrayList<>();
        }
        this.personnes.add(resultat);
    }

    @Override
    public Personne recuperee() {
        if(personnes.isEmpty()){
            return null;
        }
        log.info("input:Reponse:recuperer---------------------------------------------");
        return personnes.get(0);
    }

    @Override
    public void donnees(List<Personne> resultat) {
        log.info("input:Reponse:donner---------------------------------------------");
        this.personnes = resultat;
    }

    @Override
    public List<Personne> recuperees() {
        log.info("input:Reponse:recuperer---------------------------------------------");
        return personnes;
    }
}
