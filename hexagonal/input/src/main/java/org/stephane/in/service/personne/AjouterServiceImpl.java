package org.stephane.in.service.personne;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.stephane.domain.business.UseCaseAjouter;
import org.stephane.domain.business.personne.UseCaseAjouterPersonneImpl;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.Enregistrer;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.factory.CreateMapperDto;
import org.stephane.in.mapper.factory.TypeServiceMapperDto;

@Service
@RequiredArgsConstructor
@Qualifier("AjouterServiceImpl")
public class AjouterServiceImpl extends  AjouterService<PersonneDto> {
    @Qualifier("AjouterReponsePersonne")
    private final AjouterReponse<Personne> reponse;
    @Qualifier("EnregistrerPersonne")
    private final Enregistrer<Personne> enregistrer;

    @Override
    public PersonneDto executer(PersonneDto personneDto) {
        UseCaseAjouter<Personne> useCaseAjouterUnePersonne = new UseCaseAjouterPersonneImpl();
        Personne personne = mapper.getMapper(TypeServiceMapperDto.PERSONNE).toDomain(personneDto);
        useCaseAjouterUnePersonne.executer(personne, enregistrer, reponse);
        return mapper.getMapper(TypeServiceMapperDto.PERSONNE).toInput(reponse.recuperer());
    }


}
