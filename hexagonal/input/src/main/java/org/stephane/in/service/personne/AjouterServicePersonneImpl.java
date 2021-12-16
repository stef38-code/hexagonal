package org.stephane.in.service.personne;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stephane.domain.business.UseCaseAjouter;
import org.stephane.domain.business.personne.UseCaseAjouterPersonneImpl;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponsePersonne;
import org.stephane.domain.port.out.personne.AjouterPersonneOut;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.factory.TypeServiceMapperDto;

@Service
@RequiredArgsConstructor
public class AjouterServicePersonneImpl extends AjouterServicePersonne {
    private final AjouterReponsePersonne reponse;
    private final AjouterPersonneOut ajouter;

    @Override
    public PersonneDto executer(PersonneDto personneDto) {
        UseCaseAjouter<Personne> useCaseAjouterUnePersonne = new UseCaseAjouterPersonneImpl();
        Personne personne = getMapper(TypeServiceMapperDto.PERSONNE).toDomain(personneDto);
        useCaseAjouterUnePersonne.executer(personne, ajouter, reponse);
        return getMapper(TypeServiceMapperDto.PERSONNE).toInput(reponse.recuperer());
    }


}
