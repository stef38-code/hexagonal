package org.stephane.in.service.personne;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.stephane.domain.port.out.personne.SupprimerPersonneOut;
import org.stephane.in.dto.PersonneDto;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupprimerServicePersonneImpl extends SupprimerServicePersonne {
    private final SupprimerServicePersonne reponse;
    private final SupprimerPersonneOut supprimer;

    @Override
    public boolean executer(PersonneDto personneDto) {
        log.info("input:service:DEBUT---------------------------------------------");
        /*UseCaseAjouter<Personne> useCaseAjouterUnePersonne = new UseCaseAjouterPersonneImpl();
        Personne personne = getMapper(TypeServiceMapperDto.PERSONNE).toDomain(personneDto);
        useCaseAjouterUnePersonne.executer(personne, supprimer, reponse);*/
        log.info("input:service:FIN---------------------------------------------");
        return false;
    }

    @Override
    public boolean executer(String id) {
        log.info("input:service:DEBUT---------------------------------------------");

        log.info("input:service:FIN---------------------------------------------");
        return false;
    }


}