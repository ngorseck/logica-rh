package com.logica.rh;

import com.logica.rh.config.LoggingAspect;
import com.logica.rh.domain.Department;
import com.logica.rh.domain.Employee;
import com.logica.rh.domain.Gender;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

@Import({ AopAutoConfiguration.class, LoggingAspect.class})
public abstract class BaseTestClass {

    protected Employee getEmployee() {
        return new Employee(1L, "Mamadou Lamine", "Ba", Gender.M, "France", "Paris", "Paris defance");
    }

    protected Department getDepartment() {
        return new Department("HR", getEmployee());
    }

    protected MessageSource getMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
