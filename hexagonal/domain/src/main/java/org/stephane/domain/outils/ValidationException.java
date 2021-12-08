package org.stephane.domain.outils;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends IllegalStateException {
    private final Map<String, String> erreurs = new HashMap<>();

    public ValidationException() {
    }

    public ValidationException(Map<String, String> erreurs) {
        this.erreurs.putAll(erreurs);
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public int nombreDeErreurs() {
        return erreurs.size();
    }
}
