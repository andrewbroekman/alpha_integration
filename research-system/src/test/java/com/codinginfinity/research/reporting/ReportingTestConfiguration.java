package com.codinginfinity.research.reporting;

import com.codinginfinity.research.services.mocking.CallLoggingAspect;
import com.codinginfinity.research.services.utilities.ServiceUtilities;
import com.codinginfinity.research.services.utilities.ServiceUtilitiesBean;
import com.codinginfinity.research.validation.Validation;
import com.codinginfinity.research.validation.beanvalidation.BeanValidationBean;
import com.codinginfinity.research.validation.beanvalidation.services.ServiceValidationUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Created by andrew on 2016/04/11.
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ReportingTestConfiguration {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ReportingTestConfiguration.class);

    @Bean
    public CallLoggingAspect callLoggingAspect()
    {
        return new CallLoggingAspect();
    }

    @Bean
    public javax.validation.Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public Validation.ValidationLocal validation() {
        return new BeanValidationBean();
    }

    @Bean
    public ServiceValidationUtilities serviceValidationUtilities() {
        return new ServiceValidationUtilities();
    }

    @Bean
    public ServiceUtilities serviceUtilities() {
        return new ServiceUtilitiesBean();
    }



}
