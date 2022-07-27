package com.logica.rh.config;

import brave.context.log4j2.ThreadContextScopeDecorator;
import brave.propagation.CurrentTraceContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ApplicationConfig {

    @Bean
    CurrentTraceContext.ScopeDecorator decorator() {
        return ThreadContextScopeDecorator.get();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
