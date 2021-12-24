package org.stephane.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.in.dto.PersonneDto;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class GenererPersonneTest {
    private GenererPersonne genererPersonne;
    private LocalDate startDate;
    private LocalDate endDate;

    @BeforeEach
    void setUp() {
        genererPersonne = new GenererPersonne();
        startDate = LocalDate.of(1945, 1, 1);
        endDate = LocalDate.of(2000, 12, 31);
    }

    @Test
    void testGenereListPersonneDto() {
        assertThat(genererPersonne.genererListe(10, startDate, endDate)).hasSize(10);
    }

    @Test
    void testGenerePersonneDto() {
        PersonneDto actual = genererPersonne.generer(startDate, endDate);
        assertThat(actual.getAdresses()).isEmpty();
        assertThat(actual.getId()).isNull();
    }
}
