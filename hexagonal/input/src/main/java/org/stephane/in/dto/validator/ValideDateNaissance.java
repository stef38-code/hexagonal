package org.stephane.in.dto.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = DateNaissanceValidator.class)
@Documented
public  @interface ValideDateNaissance {
    String message() default "Le format de la date de naissance n'est pas correcte !!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    int ageMinimum () default 0;
}
