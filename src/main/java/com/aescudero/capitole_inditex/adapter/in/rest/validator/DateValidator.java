package com.aescudero.capitole_inditex.adapter.in.rest.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements ConstraintValidator<ValidDate, String> {

    private DateTimeFormatter formatter;

    @Override
    public void initialize(ValidDate constraintAnnotation) {
        formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    }

    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext context) {
        if (dateStr == null) {
            return true;
        }

        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
