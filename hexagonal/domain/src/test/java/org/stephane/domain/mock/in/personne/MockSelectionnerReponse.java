package org.stephane.domain.mock.in.personne;

import org.apache.commons.collections4.CollectionUtils;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.SelectionnerReponse;

import java.util.ArrayList;
import java.util.List;

public class MockSelectionnerReponse extends SelectionnerReponse<Personne> {
    private List<Personne> personnes = new ArrayList<>();

    @Override
    public void donnee(Personne resultat) {
        if (CollectionUtils.isNotEmpty(personnes)) {
            personnes.clear();
        }
        personnes.add(resultat);
    }

    @Override
    public Personne recuperee() {
        if (CollectionUtils.isNotEmpty(personnes)) {
            return personnes.get(0);
        }
        return null;
    }

    @Override
    public void donnees(List<Personne> resultat) {
        personnes = resultat;
    }

    @Override
    public List<Personne> recuperees() {
        return personnes;
    }
}
