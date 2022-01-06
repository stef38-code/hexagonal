package org.stephane.domain.business.personne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.domain.business.UseCaseSelectionner;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.mock.in.personne.MockSelectionnerPersonne;
import org.stephane.domain.mock.in.personne.MockSelectionnerReponse;
import org.stephane.domain.port.in.SelectionnerReponse;
import org.stephane.domain.port.out.SelectionnerOut;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class UseCaseSelectionnerPersonneImplTest {
    SelectionnerOut<Personne> mockRepository;
    SelectionnerReponse<Personne> mockReponse;

    @BeforeEach
    void setUp() {
        mockRepository = new MockSelectionnerPersonne();
        mockReponse = new MockSelectionnerReponse();
    }

    @Test
    void editer_Lorsque_unId_Attend_UnePersonne() {
        UseCaseSelectionner<Personne> business = new UseCaseSelectionnerPersonneImpl();
        //Conditions préalables (given)

        //Une action se produit (when)
        business.executer("7235d657-84a7-47c4-b93a-7ae552ae07ff", mockRepository, mockReponse);
        Personne personne = mockReponse.recuperee();
        //Vérifier la sortie (then)
        then(personne).isNotNull();
        then(personne.getId()).hasToString("7235d657-84a7-47c4-b93a-7ae552ae07ff");
        then(personne.getNom()).hasToString("Elégante");
        then(personne.getPrenom()).hasToString("Fournie");
        then(personne.getDateNaissance()).isEqualTo(LocalDate.of(1980, 1, 1));
    }

    @Test
    void lister_Attend_UneListDePersonnes() {
        UseCaseSelectionner<Personne> business = new UseCaseSelectionnerPersonneImpl();
        //Conditions préalables (given)

        //Une action se produit (when)
        business.executer(mockRepository, mockReponse);
        List<Personne> personnes = mockReponse.recuperees();

        //Vérifier la sortie (then)
        then(personnes).isNotEmpty().hasSize(2);
        Personne personne = personnes.get(0);
        then(personne).isNotNull();
        then(personne.getId()).hasToString("7235d657-84a7-47c4-b93a-7ae552ae07ff");
        then(personne.getNom()).hasToString("Elégante");
        then(personne.getPrenom()).hasToString("Fournie");
        then(personne.getDateNaissance()).isEqualTo(LocalDate.of(1980, 1, 1));

        personne = personnes.get(1);
        then(personne).isNotNull();
        then(personne.getId()).hasToString("c77096a7-e2a2-4239-afa6-ca5cc49d67d3");
        then(personne.getNom()).hasToString("Elégant");
        then(personne.getPrenom()).hasToString("Lion");
        then(personne.getDateNaissance()).isEqualTo(LocalDate.of(1980, 1, 1));
    }
}
