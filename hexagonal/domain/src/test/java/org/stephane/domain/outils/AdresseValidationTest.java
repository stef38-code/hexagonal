package org.stephane.domain.outils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.assertj.core.api.BDDAssertions.then;

class AdresseValidationTest {
    private Map<String,String> erreurs;

    @BeforeEach
    void setUp() {
        erreurs = new HashMap<>();
    }

    @ParameterizedTest
    @CsvSource( {
                    "code postal,,Le code postal est obligatoire !!",
                    "code postal,A1234,Le code postal n'est pas valide !!",
                    "code postal,012345,Le code postal n'est pas valide !!"
            } )
    void valideCodePostal_vide(String champ,String value,String message) {
        AdresseValidation.valideCodePostal(champ, value, erreurs);
        assertThat(erreurs).isNotEmpty().hasSize(1).containsOnly(entry(champ, message));
    }

    @Test
    void valideCodePostal() {
        StringBuilder sb = new StringBuilder();
        AdresseValidation.valideCodePostal("code postal", "75001", erreurs);
        then(sb).isEmpty();
    }
}
