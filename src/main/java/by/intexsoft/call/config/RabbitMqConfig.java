package by.intexsoft.call.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static by.intexsoft.call.pojo.type.Type.*;

/**
 * Class configuration RabbitMQ
 */
@Configuration
@ComponentScan("by.intexsoft.call")
@PropertySource("classpath:rabbitmq.properties")
public class RabbitMqConfig {
    @Value("${rabbit.host}")
    private String rabbitHost;
    @Value("${rabbit.user}")
    private String rabbitUser;
    @Value("${rabbit.password}")
    private String rabbitPassword;
    @Value("${rabbit.exchange}")
    private String rabbitExchange;

    /**
     * Create a {@link CachingConnectionFactory}
     */
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitHost);
        connectionFactory.setUsername(rabbitUser);
        connectionFactory.setPassword(rabbitPassword);
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
     * Create a {@link Queue}
     */
    @Bean
    public Queue callQueue() {
        return new Queue(CALL.toString());
    }

    /**
     * Create a {@link Queue}
     */
    @Bean
    public Queue smsQueue() {
        return new Queue(SMS.toString());
    }

    /**
     * Create a {@link Queue}
     */
    @Bean
    public Queue mmsQueue() {
        return new Queue(MMS.toString());
    }

    /**
     * Create a {@link DirectExchange}.
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(rabbitExchange);
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
     */
    @Bean
    public RabbitTemplate template() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setExchange(rabbitExchange);
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
