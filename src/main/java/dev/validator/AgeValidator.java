package dev.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<AgeConstraint, LocalDate> {

    private int minAge;

    @Override
    public void initialize(AgeConstraint constraintAnnotation) {
        minAge = constraintAnnotation.minAge();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        LocalDate now = LocalDate.now();
        return Period.between(value, now).getYears() >= minAge;
    }
}
