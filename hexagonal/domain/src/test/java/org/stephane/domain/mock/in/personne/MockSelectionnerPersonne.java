package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.entities.PersonneBuilder;
import org.stephane.domain.port.out.personne.SelectionnerPersonneOut;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockSelectionnerPersonne implements SelectionnerPersonneOut {

    @Override
    public Personne executer(String id) {
        return PersonneBuilder.aPersonne()
                .id(id)
                .nom("Elégante")
                .prenom("Fournie")
                .dateNaissance(LocalDate.of(1980, 1, 1))
                .build();
    }

    @Override
    public List<Personne> executer() {
        return getListePersonne();
    }

    private Personne getPersonne(String id, String nom, String prenom, LocalDate dateNaissance) {
        return PersonneBuilder.aPersonne()
                .id(id)
                .nom(nom)
                .prenom(prenom)
                .dateNaissance(dateNaissance)
                .build();
    }

    private List<Personne> getListePersonne() {
        List<Personne> list = new ArrayList<>();
        list.add(
                PersonneBuilder.aPersonne()
                        .id("7235d657-84a7-47c4-b93a-7ae552ae07ff")
                        .nom("Elégante")
                        .prenom("Fournie")
                        .dateNaissance(LocalDate.of(1980, 1, 1))
                        .build()
        );
        list.add(
                PersonneBuilder.aPersonne()
                        .id("c77096a7-e2a2-4239-afa6-ca5cc49d67d3")
                        .nom("Elégant")
                        .prenom("Lion")
                        .dateNaissance(LocalDate.of(1980, 1, 1))
                        .build()
        );
        return list;
    }
}
