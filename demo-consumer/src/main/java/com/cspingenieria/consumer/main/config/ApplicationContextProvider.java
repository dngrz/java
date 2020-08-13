package com.cspingenieria.consumer.main.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextProvider {
    
//    protected final Log log = LogFactory.getLog(getClass());
    
    private ApplicationContext applicationContext;
    private static final ApplicationContextProvider provider = new ApplicationContextProvider();

    private ApplicationContextProvider() throws ExceptionInInitializerError {
        try {
            this.applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        } catch (Throwable ex) {
            System.err.println(ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public synchronized static ApplicationContextProvider getInstance() throws ExceptionInInitializerError {
        return provider;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    
}
