package com.redflag.project.common.validators;

import com.redflag.project.common.constants.ErrorMessages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy= EmailValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {

    String message() default ErrorMessages.INVALID_EMAIL;
    Class<?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

}


