package org.stephane.domain.outils;

public class OutilsValidation {
    private OutilsValidation() {
    }

    public static void notNullNotEmpty(String champ, String value, StringBuilder mb) {
        if (isNull(value)) {
            mb.append("Le ".concat(champ).concat(" est obligatoire !!"));
        } else {
            if (isEmpty(value)) {
                mb.append("Le ".concat(champ).concat(" ne peut pas être vide !!"));
            }
        }
    }

    public static void notNull(String champ, Object value, StringBuilder mb) {
        if (isNull(value)) {
            mb.append("Le ".concat(champ).concat(" est obligatoire !!"));
        }
    }
    public static void notEmpty(String champ, String value, StringBuilder mb) {
        if (isEmpty(value)) {
            mb.append("Le ".concat(champ).concat(" ne peut pas être vide !!"));
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
