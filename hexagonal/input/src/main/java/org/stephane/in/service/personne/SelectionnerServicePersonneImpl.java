package org.stephane.in.service.personne;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.stephane.domain.business.UseCaseAjouter;
import org.stephane.domain.business.UseCaseSelectionner;
import org.stephane.domain.business.personne.UseCaseAjouterPersonneImpl;
import org.stephane.domain.business.personne.UseCaseSelectionnerPersonneImpl;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponsePersonne;
import org.stephane.domain.port.in.personne.SelectionnerReponsePersonne;
import org.stephane.domain.port.out.personne.AjouterPersonneOut;
import org.stephane.domain.port.out.personne.SelectionnerPersonneOut;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.mapper.factory.TypeServiceMapperDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SelectionnerServicePersonneImpl extends SelectionnerServicePersonne {
    private final SelectionnerReponsePersonne reponse;
    private final SelectionnerPersonneOut selectionner;

    @Override
    public List<PersonneDto> executer() {
        log.info("input:service:DEBUT---------------------------------------------");
        UseCaseSelectionner<Personne> useCaseSelectionnerPersonne = new UseCaseSelectionnerPersonneImpl();
        useCaseSelectionnerPersonne.executer(selectionner,reponse);
        log.info("input:service:FIN---------------------------------------------");
        return getMapper(TypeServiceMapperDto.PERSONNE).toInput(reponse.recuperees());
    }

    @Override
    public PersonneDto executer(String id) {
        log.info("input:service:DEBUT---------------------------------------------");
        UseCaseSelectionner<Personne> useCaseSelectionnerPersonne = new UseCaseSelectionnerPersonneImpl();
        useCaseSelectionnerPersonne.executer(id,selectionner,reponse);
        log.info("input:service:FIN---------------------------------------------");
        return getMapper(TypeServiceMapperDto.PERSONNE).toInput(reponse.recuperee());
    }
}
