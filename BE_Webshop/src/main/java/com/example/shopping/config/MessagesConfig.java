package com.example.shopping.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessagesConfig {
    @Bean("messageSource")
    public MessageSource getMessageSource ( ) {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setDefaultEncoding("utf-8");
        ms.setBasenames(" classpath:messages/messages ");
        return ms;
    }
}
