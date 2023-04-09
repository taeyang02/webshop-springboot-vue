package com.example.shopping.exception;

import com.example.shopping.config.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.shopping.Utils.CommonUtils;

import java.text.MessageFormat;
import java.util.Optional;

@Component
public class GlobalException {

    private static MessageProperties propertiesConfig;

    @Autowired
    public GlobalException(MessageProperties propertiesConfig) {
        GlobalException.propertiesConfig = propertiesConfig;
    }

    /**
     * Returns new RuntimeException based on template and args
     *
     * @param messageTemplate
     * @param args
     * @return
     */
    public static RuntimeException throwException(String messageTemplate, String... args) {
        return new RuntimeException(format(messageTemplate, args));
    }

    /**
     * Returns new RuntimeException based on EntityType, ExceptionType and args
     *
     * @param entityType
     * @param exceptionType
     * @param args
     * @return
     */
    public static RuntimeException throwException(EntityType entityType, ExceptionType exceptionType, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType);
        return throwException(exceptionType, messageTemplate, args);
    }

    /**
     * Returns new RuntimeException based on EntityType, ExceptionType and args
     *
     * @param entityType
     * @param exceptionType
     * @param code
     * @param args
     * @return
     */
    public static RuntimeException throwExceptionWithCode(EntityType entityType, ExceptionType exceptionType, String code, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType).concat(".").concat(code);
        return throwException(exceptionType, messageTemplate, args);
    }

    /**
     * Returns new RuntimeException based on EntityType, ExceptionType, messageTemplate and args
     *
     * @param entityType
     * @param exceptionType
     * @param messageTemplate
     * @param args
     * @return
     */
    public static RuntimeException throwExceptionWithTemplate(EntityType entityType, ExceptionType exceptionType, String messageTemplate, String... args) {
        return throwException(exceptionType, messageTemplate, args);
    }

    /**
     * Returns new RuntimeException based on template and args
     *
     * @param messageTemplate
     * @param args
     * @return
     */
    private static RuntimeException throwException(ExceptionType exceptionType, String messageTemplate, String... args) {
        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)) {
            return new EntityNotFoundException(format(messageTemplate, args));
        } else if (ExceptionType.DUPLICATE_ENTITY.equals(exceptionType)) {
            return new DuplicateEntityException(format(messageTemplate, args));
        } else if (ExceptionType.ENTITY_ALREADY_EXIST.equals(exceptionType)) {
            return new EntityAlreadyExistException(format(messageTemplate, args));
        }
        return new RuntimeException(format(messageTemplate, args));
    }

    private static String getMessageTemplate(EntityType entityType, ExceptionType exceptionType) {
        return entityType.name().concat(".").concat(exceptionType.getValue());
    }

    public static String format(String template, String ... args) {
        Optional<String> templateContent = Optional.ofNullable(propertiesConfig.getConfigValue(template));
        if (templateContent.isPresent()) {
        	return MessageFormat.format(templateContent.get(), (Object[]) args);
        }
        return String.format(template, (Object[]) args);
    }
    
    public static String format(String template) {
    	Optional<String> templateContent = Optional.ofNullable(propertiesConfig.getConfigValue(template));
        if (templateContent.isPresent()) {
            return templateContent.get();
        }
        return template;
    }
}
