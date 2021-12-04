package org.stephane.domain.outils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutilsValidationTest {

    @Test
    void notNullNotEmpty() {
        StringBuilder sb = new StringBuilder();
        OutilsValidation.notNullNotEmpty("nom",null,sb);
        OutilsValidation.notNullNotEmpty("surnom","",sb);
        OutilsValidation.notNullNotEmpty("prenom","bob",sb);
        assertThat(sb)
                .contains("Le nom est obligatoire !!")
                .contains("Le surnom ne peut pas être vide !!")
                .doesNotContain("prenom");
    }

    @Test
    void notNull() {
        StringBuilder sb = new StringBuilder();
        OutilsValidation.notNull("nom",null,sb);
        String prenom = "bob";
        OutilsValidation.notNull("prenom",prenom,sb);
        assertThat(sb).contains("Le nom est obligatoire !!").doesNotContain("prenom");
    }

    @Test
    void notEmpty() {
        StringBuilder sb = new StringBuilder();
        OutilsValidation.notEmpty("nom","",sb);
        String prenom = "bob";
        OutilsValidation.notEmpty("prenom",prenom,sb);
        assertThat(sb).contains("Le nom ne peut pas être vide !!").doesNotContain("prenom");
    }



    @Test
    void isNotEmpty() {
        assertThat(OutilsValidation.isNotEmpty("")).isFalse();
        assertThat(OutilsValidation.isNotEmpty("azerty")).isTrue();
    }
    @Test
    void isNotNull() {
        assertThat(OutilsValidation.isNotNull(null)).isFalse();
        assertThat(OutilsValidation.isNotNull("azerty")).isTrue();
    }
}
