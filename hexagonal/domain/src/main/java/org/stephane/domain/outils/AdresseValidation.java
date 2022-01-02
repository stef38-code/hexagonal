package org.stephane.domain.outils;

import java.util.Map;

public class AdresseValidation extends OutilsValidation {

    private static final String REGEX = "\\d{5}$";

    public static void valideCodePostal(String champ, String codePostalValue, Map<String,String> erreurs) {
        notNullNotEmpty(champ, codePostalValue, erreurs);
        if (isNotNull(codePostalValue) && ! codePostalValue.matches(REGEX)) {
            erreurs.put(champ,"Le ".concat(champ).concat(" n'est pas valide !!"));
        }
    }
}
