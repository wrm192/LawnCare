package com.redflag.project.common.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private Pattern pattern;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    @Override
    // Empty Method
    public void initialize(ValidEmail constraintAnnotation) { }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Matcher matcher = pattern.matcher(email);
        pattern = Pattern.compile(EMAIL_PATTERN);
        return matcher.matches();
    }
}
