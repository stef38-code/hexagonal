package org.stephane.in.personne;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stephane.domain.business.personne.UseCaseAjouter;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterUnePersonneReponse;
import org.stephane.domain.port.out.personne.Enregistrer;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.PersonneDtoMapper;
import org.stphane.output.personne.EnregistrerUnePersonneImpl;

@Service
@RequiredArgsConstructor
public class AjouterUnePersonneService {
    private final AjouterUnePersonneReponse reponse;
    private final Enregistrer enregistrer;
    private final UseCaseAjouter useCaseAjouterUnePersonne;

    public AjouterUnePersonneService() {
        reponse = new AjouterUnePersonneReponseImpl();
        enregistrer = new EnregistrerUnePersonneImpl();
        useCaseAjouterUnePersonne = new UseCaseAjouter();
    }

    public PersonneDto ajouter(PersonneDto personneDto) {
        Personne personne = PersonneDtoMapper.INSTANCE.to(personneDto);
        useCaseAjouterUnePersonne.ajouterUnePersonne(personne, enregistrer, reponse);
        return PersonneDtoMapper.INSTANCE.to(reponse.recuperer());
    }
}
