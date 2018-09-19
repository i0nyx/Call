package by.intexsoft.call.config;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import static by.intexsoft.call.constant.RabbitMqConstant.*;

/**
 * Class configuration RabbitMQ
 */
@Configuration
@ComponentScan("by.intexsoft.call")
@PropertySource("classpath:rabbitmq.properties")
@AllArgsConstructor
public class RabbitMqConfig {
    private final Environment env;

    /**
     * Create a {@link CachingConnectionFactory}
     */
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(env.getProperty("rabbit.host"));
        connectionFactory.setUsername(env.getProperty("rabbit.user"));
        connectionFactory.setPassword(env.getProperty("rabbit.password"));
        return connectionFactory;
    }

    /**
     * Create a {@link RabbitAdmin}
     *
     * @return {@link AmqpAdmin}
     */
    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    /**
     * Creatge a {@link Queue}
     */
    @Bean
    public Queue callQueue() {
        return new Queue(CALL_QUEUE);
    }

    /**
     * Creatge a {@link Queue}
     */
    @Bean
    public Queue smsQueue() {
        return new Queue(SMS_QUEUE);
    }

    /**
     * Creatge a {@link Queue}
     */
    @Bean
    public Queue mmsQueue() {
        return new Queue(MMS_QUEUE);
    }

    /**
     * Create a {@link DirectExchange}.
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    /**
     * Create a {@link BindingBuilder}.
     *
     * @return {@link Binding}
     * @see #callQueue()
     * @see #directExchange()
     */
    @Bean
    public Binding callBinding() {
        return BindingBuilder.bind(callQueue()).to(directExchange()).with(CALL);
    }

    /**
     * Create a {@link BindingBuilder}.
     *
     * @return {@link Binding}
     * @see #smsQueue()
     * @see #directExchange()
     */
    @Bean
    public Binding smsBinding() {
        return BindingBuilder.bind(smsQueue()).to(directExchange()).with(SMS);
    }

    /**
     * Create a {@link BindingBuilder}.
     *
     * @return {@link Binding}
     * @see #mmsQueue()
     * @see #directExchange()
     */
    @Bean
    public Binding mmsBinding() {
        return BindingBuilder.bind(mmsQueue()).to(directExchange()).with(MMS);
    }

    /**
     * Create a {@link RabbitTemplate}.
     *
     * @see #connectionFactory()
     * @see #messageConverter()
     */
    @Bean
    public RabbitTemplate template() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setExchange(EXCHANGE);
        return template;
    }

    /**
     * Create a {@link JsonMessageConverter}
     *
     * @return {@link MessageConverter}
     */
    @Bean
    public MessageConverter messageConverter() {
        return new JsonMessageConverter();
    }

}
