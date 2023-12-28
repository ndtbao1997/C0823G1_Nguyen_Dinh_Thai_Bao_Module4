package com.example.registerformuser.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailAnnotationValidator.class)
@Documented
public @interface EmailAnnotation {
    String message() default "Email này đã tồn tại!!!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
