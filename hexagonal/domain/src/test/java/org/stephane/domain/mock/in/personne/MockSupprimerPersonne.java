package org.stephane.domain.mock.in.personne;

import org.apache.commons.lang3.StringUtils;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.Supprimer;

import java.util.Objects;

public class MockSupprimerPersonne extends Supprimer<Personne> {
    @Override
    public boolean execute(Personne domain) {
        return Objects.nonNull(domain);
    }

    @Override
    public boolean execute(String id) {
        return StringUtils.isNotBlank(id);
    }
}
