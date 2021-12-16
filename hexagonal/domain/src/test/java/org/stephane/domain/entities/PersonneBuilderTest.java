package org.stephane.domain.entities;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.stephane.domain.outils.ValidationException;

import java.time.LocalDate;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class PersonneBuilderTest {
    @Test
    void toStringValue() {
        Personne personne = PersonneBuilder.aPersonne()
                .id("1234567890")
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.of(1991, 12, 4))
                .build();
        assertThat(personne.toString()).hasToString("Personne{id='1234567890', nom='Solomon', prenom='Castro', dateNaissance=1991-12-04, adresses=[]}");
    }

    @Test
    void validate_notException() {
        Assertions.assertThatCode(() -> PersonneBuilder.aPersonne()
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build()).doesNotThrowAnyException();
    }

    @Test
    void validate_exception() {
        Throwable assertionError = catchThrowable(() -> PersonneBuilder.aPersonne()
                .nom(null)
                .prenom("")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build());
        assertThat(assertionError).isInstanceOf(IllegalStateException.class);
        ValidationException erreurs = (ValidationException) assertionError;
        Map<String, String> map = erreurs.getErreurs();
        assertThat(map).isNotEmpty().hasSize(2)
                .contains(entry("nom", "Le nom est obligatoire !!"))
                .contains(entry("prenom", "Le prenom ne peut pas être vide !!"));

    }

    @Test
    void validate_exception1() {
        Throwable assertionError = catchThrowable(() -> {
            PersonneBuilder.aPersonne()
                    .nom("")
                    .prenom(null)
                    .dateNaissance(null)
                    .build();
        });
        assertThat(assertionError).isInstanceOf(ValidationException.class);
        ValidationException erreurs = (ValidationException) assertionError;
        Map<String, String> map = erreurs.getErreurs();
        assertThat(map).isNotEmpty().hasSize(3)
                .contains(entry("nom", "Le nom ne peut pas être vide !!"))
                .contains(entry("prenom", "Le prenom est obligatoire !!"))
                .contains(entry("date de naissance", "Le date de naissance est obligatoire !!"));

    }

}
