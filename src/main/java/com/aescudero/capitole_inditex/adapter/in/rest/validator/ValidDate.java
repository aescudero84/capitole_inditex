package com.aescudero.capitole_inditex.adapter.in.rest.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {
    String message() default "Invalid format. Expected ISO_DATE_TIME (e.g., 2020-07-01T10:00:00)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
