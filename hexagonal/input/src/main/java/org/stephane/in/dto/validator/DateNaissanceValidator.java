package org.stephane.in.dto.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class DateNaissanceValidator implements ConstraintValidator<ValideDateNaissance, Object> {
    private int ageMinimum;

    @Override
    public void initialize(ValideDateNaissance constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        ageMinimum = constraintAnnotation.ageMinimum();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return false;
        if (!(value instanceof LocalDate)) return false;
        LocalDate localDateValue = (LocalDate) value;
        LocalDate dateDuJour = LocalDate.now();
        if (localDateValue.isAfter(dateDuJour)) return false;

        if (ageMinimum > 0) {
            return (Period.between(localDateValue, dateDuJour).getYears() >= ageMinimum);
        }

        return true;
    }
}
