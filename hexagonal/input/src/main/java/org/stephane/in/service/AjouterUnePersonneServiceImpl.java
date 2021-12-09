package org.stephane.in.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.stephane.domain.business.personne.UseCaseAjouter;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterUnePersonneReponse;
import org.stephane.domain.port.out.personne.Enregistrer;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.PersonneDtoMapper;

@Service
@RequiredArgsConstructor
public class AjouterUnePersonneServiceImpl implements AjouterUnePersonneService {
    private final AjouterUnePersonneReponse reponse;
    private final Enregistrer enregistrer;

    @Override
    public PersonneDto ajouter(PersonneDto personneDto) {
        UseCaseAjouter useCaseAjouterUnePersonne = new UseCaseAjouter();
        Personne personne = PersonneDtoMapper.INSTANCE.to(personneDto);
        useCaseAjouterUnePersonne.ajouterUnePersonne(personne, enregistrer, reponse);
        return PersonneDtoMapper.INSTANCE.to(reponse.recuperer());
    }
}
