package com.example.registerformuser.annotation;

import com.example.registerformuser.model.Use;
import com.example.registerformuser.service.IUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Objects;

@Component
public class EmailAnnotationValidator implements ConstraintValidator<EmailAnnotation, String> {
    @Autowired
    private IUseService iUseService;
    private EmailAnnotation emailAnnotation;

    @Override
    public void initialize(EmailAnnotation emailAnnotation) {
        this.emailAnnotation = emailAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try{
            List<Use> useList = (List<Use>) iUseService.findAll();
            for (Use use : useList) {
                if (Objects.equals(use.getEmail(), value)) {
                    return false;
                }
            }
            return true;
        }catch (Exception e){
            return true;
        }
    }
}
