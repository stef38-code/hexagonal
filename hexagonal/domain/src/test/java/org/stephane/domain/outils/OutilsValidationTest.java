package org.stephane.domain.outils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class OutilsValidationTest {
    private Map<String,String> erreurs;

    @BeforeEach
    void setUp() {
        erreurs = new HashMap<>();
    }
    @ParameterizedTest
    @CsvSource( {
            "nom,,Le nom est obligatoire !!",
            "surnom,'',Le surnom ne peut pas être vide !!",
    } )
    void notNullNotEmpty(String champ,String value,String message) {
        OutilsValidation.notNullNotEmpty(champ, value, erreurs);
        OutilsValidation.notNullNotEmpty("champ", "value", erreurs);
        assertThat(erreurs).isNotEmpty().hasSize(1).containsOnly(entry(champ, message));
    }

    @ParameterizedTest
    @CsvSource( {
            "nom,,Le nom est obligatoire !!"
    } )
    void notNull(String champ,String value,String message) {
        OutilsValidation.notNull("nom", value, erreurs);
        OutilsValidation.notNullNotEmpty("champ", "value", erreurs);
        assertThat(erreurs).isNotEmpty().hasSize(1).containsOnly(entry(champ, message));
    }

    @ParameterizedTest
    @CsvSource( {
            "nom,'',Le nom ne peut pas être vide !!"
    } )
    void notEmpty(String champ,String value,String message) {
        OutilsValidation.notEmpty(champ, value, erreurs);
        OutilsValidation.notNullNotEmpty("champ", "value", erreurs);
        assertThat(erreurs).isNotEmpty().hasSize(1).containsOnly(entry(champ, message));
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
