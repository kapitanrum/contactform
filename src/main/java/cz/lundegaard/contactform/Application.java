package cz.lundegaard.contactform;

import cz.lundegaard.contactform.frontend.ServletContextAttributePopulator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * Main application starter class.
 */
@SpringBootApplication()
public class Application implements WebMvcConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean result = new LocalValidatorFactoryBean();
        result.setMessageInterpolator(new ResourceBundleMessageInterpolator(
                new MessageSourceResourceBundleLocator( messageSource())
        ));
        return result;
    }

    /**
     * For using bean validation messages in JSF.
     */
    @Bean
    public ServletContextAttributePopulator servletContextPopluator() {
        ServletContextAttributePopulator result = new ServletContextAttributePopulator();
        Map<String, Object> map = new HashMap<>();
        map.put("javax.faces.validator.beanValidator.ValidatorFactory", validator());
        result.setAttributes(map);
        return result;
    }


}
