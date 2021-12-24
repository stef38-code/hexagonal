package org.stephane.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.in.dto.AdresseDto;

import static org.assertj.core.api.Assertions.assertThat;

class GenererAdresseTest {

    private GenererAdresse genererAdresse;

    @BeforeEach
    void setUp() {
        genererAdresse = new GenererAdresse();
    }

    @Test
    void testGenereListAdresseDto() {
        assertThat(genererAdresse.genererListe(10)).hasSize(10);
    }

    @Test
    void testGenereAdresseDto() {
        AdresseDto actualGenereAdresseDtoResult = genererAdresse.generer();
        assertThat(actualGenereAdresseDtoResult.getAppartementEscalierEtage()).isNull();
        assertThat(actualGenereAdresseDtoResult.getPersonnes()).isEmpty();
        assertThat(actualGenereAdresseDtoResult.getPays()).isNull();
        assertThat(actualGenereAdresseDtoResult.getId()).isNull();
        assertThat(actualGenereAdresseDtoResult.getComplementAdresse()).isNull();
        assertThat(actualGenereAdresseDtoResult.getBatimentResidence()).isNull();
        assertThat(actualGenereAdresseDtoResult.getVille()).isNotNull();
        assertThat(actualGenereAdresseDtoResult.getNumeroNomVoie()).isNotNull();
    }


}

