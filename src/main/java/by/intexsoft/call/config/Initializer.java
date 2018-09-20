package by.intexsoft.call.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Initialization configuration class
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{CassandraConfig.class, RabbitMqConfig.class};
    }
}
