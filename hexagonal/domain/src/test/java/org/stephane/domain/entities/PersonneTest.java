package org.stephane.domain.entities;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PersonneTest {
    @Test
    void toStringValue(){
        Personne personne = Personne.Builder.newInstance()
                .id("1234567890")
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.of(1991,12,4))
                .build();
        Assertions.assertThat(personne.toString()).hasToString("Personne{id='1234567890', nom='Solomon', prenom='Castro', dateNaissance=1991-12-04}");
    }
    @Test
    void validate_notException() {
        Assertions.assertThatCode(() -> Personne.Builder.newInstance()
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build()).doesNotThrowAnyException();
    }
    @Test
    void validate_exception() {
        Assertions.assertThatCode(() -> Personne.Builder.newInstance()
                        .nom(null)
                        .prenom("")
                        .dateNaissance(LocalDate.now().minusYears(30))
                        .build()).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Le nom est obligatoire !!")
                .hasMessageContaining("Le prenom ne peut pas être vide !!");
    }
    @Test
    void validate_exception1() {
        Assertions.assertThatCode(() -> Personne.Builder.newInstance()
                        .nom("")
                        .prenom(null)
                        .dateNaissance(null)
                        .build()).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Le nom ne peut pas être vide !!")
                .hasMessageContaining("Le prenom est obligatoire !!")
                .hasMessageContaining("Le date de naissance est obligatoire !!");
    }

}
