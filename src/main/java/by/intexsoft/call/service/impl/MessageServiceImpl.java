package by.intexsoft.call.service.impl;

import by.intexsoft.call.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * {@inheritDoc}
 */
@Service
@Slf4j
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final RabbitTemplate template;

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessageToQueue(String key, String message) {
        template.convertAndSend(key, message);
    }
}
