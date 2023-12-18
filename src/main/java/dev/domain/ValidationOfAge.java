package dev.domain;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidationOfAge.class)
@Documented
@interface IAgeValidatorInterface {
    String message() default "Age must be 18 ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}



public class ValidationOfAge implements ConstraintValidator<IAgeValidatorInterface, LocalDate> {
    @Override
    public void initialize(IAgeValidatorInterface constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
        if (dateOfBirth == null) {
            return false;
        }

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);

        return period.getYears() >= 18;
    }
}
