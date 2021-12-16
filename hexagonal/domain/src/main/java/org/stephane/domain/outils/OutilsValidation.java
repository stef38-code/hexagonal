package org.stephane.domain.outils;

import java.util.Map;

public class OutilsValidation {

// --Commented out by Inspection START (16/12/2021 14:06):
//    protected OutilsValidation() {
//    }
// --Commented out by Inspection STOP (16/12/2021 14:06)
    public static void notNullNotEmpty(String champ, String value, Map<String,String> erreurs) {
        if (isNull(value)) {
            erreurs.put(champ,"Le ".concat(champ).concat(" est obligatoire !!"));
        } else {
            if (isEmpty(value)) {
                erreurs.put(champ,"Le ".concat(champ).concat(" ne peut pas être vide !!"));
            }
        }
    }

    public static void notNull(String champ, Object value, Map<String,String> erreurs) {
        if (isNull(value)) {
            erreurs.put(champ,"Le ".concat(champ).concat(" est obligatoire !!"));
        }
    }
    public static void notEmpty(String champ, String value, Map<String,String> erreurs) {
        if (isEmpty(value)) {
            erreurs.put(champ,"Le ".concat(champ).concat(" ne peut pas être vide !!"));
        }
    }

    public static boolean isEmpty(String value) {
        return value.length() == 0;
    }
    public static boolean isNotEmpty(String value) {
        return value.length() > 0;
    }
    public static boolean isNull(Object value) {
        return value == null;
    }

    public static boolean isNotNull(Object value) {
        return value != null;
    }
}
