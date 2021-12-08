package org.stephane.in.personne;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stephane.domain.business.personne.UseCaseAjouter;
import org.stephane.domain.port.in.personne.AjouterUnePersonneReponse;
import org.stephane.domain.port.out.personne.Enregistrer;
import org.stephane.in.dto.PersonneDto;

@Service
@RequiredArgsConstructor
public class AjouterUnePersonneService {
    private final AjouterUnePersonneReponse reponse;
    private final Enregistrer enregistrer;
    //private final UseCaseAjouter UseCaseAjouterUnePersonne;
    public AjouterUnePersonneService() {
        reponse = new AjouterUnePersonneReponseImpl();
    }

    public PersonneDto ajouter(PersonneDto personneDto) {

    }
}
